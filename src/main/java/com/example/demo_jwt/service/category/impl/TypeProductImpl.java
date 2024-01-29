package com.example.demo_jwt.service.category.impl;

import com.example.demo_jwt.model.category.TypeProduct;
import com.example.demo_jwt.repository.category.TypeProductRepository;
import com.example.demo_jwt.service.category.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductImpl implements ITypeProductService {

    @Autowired
    private TypeProductRepository typeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }
}
