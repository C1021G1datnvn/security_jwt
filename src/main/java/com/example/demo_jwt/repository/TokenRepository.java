package com.example.demo_jwt.repository;

import com.example.demo_jwt.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

//    @Query(value = "SELECT t FROM Token t INNER JOIN User u ON t.user.id = u.id WHERE u.id = :userId AND (t.expired = false OR t.revoked = false )")
//    List<Token> findAllValidTokenByUser(@Param("userId")Integer id);
//
//    Optional<Token> findByToken(String token);
}
