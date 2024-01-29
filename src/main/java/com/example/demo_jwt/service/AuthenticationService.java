package com.example.demo_jwt.service;

import com.example.demo_jwt.config.JwtService;
import com.example.demo_jwt.controller.AuthenticationRequest;
import com.example.demo_jwt.controller.AuthenticationResponse;
import com.example.demo_jwt.controller.RegisterRequest;
import com.example.demo_jwt.model.user.Role;
import com.example.demo_jwt.model.user.User;
import com.example.demo_jwt.repository.TokenRepository;
import com.example.demo_jwt.repository.UserRepository;
import com.example.demo_jwt.token.Token;
import com.example.demo_jwt.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var saveUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(saveUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
//
//    private void revokedAllUserTokens(User user) {
//        var validUserToken = tokenRepository.findAllValidTokenByUser(user.getId());
//        if (validUserToken.isEmpty()) {
//            validUserToken.forEach(t -> {
//                t.setExpired(true);
//                t.setRevoked(true);
//            });
//            tokenRepository.saveAll(validUserToken);
//        }
//    }

    private void saveUserToken(User saveUser, String jwtToken) {
        var token = Token.builder()
                .user(saveUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
//        revokedAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
