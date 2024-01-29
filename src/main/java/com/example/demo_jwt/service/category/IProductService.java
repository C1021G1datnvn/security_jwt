package com.example.demo_jwt.service.category;

import com.example.demo_jwt.model.category.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(Long id);
    Product update(Product product,Long id);
    void save(Product product);
    void remove(Long id);
    Page<Product> searchByName(String name, Pageable pageable);
}
