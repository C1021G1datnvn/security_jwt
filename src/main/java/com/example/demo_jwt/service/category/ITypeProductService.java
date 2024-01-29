package com.example.demo_jwt.service.category;

import com.example.demo_jwt.model.category.TypeProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITypeProductService {
    List<TypeProduct> findAll();
}
