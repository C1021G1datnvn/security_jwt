package com.example.demo_jwt.service.category.impl;

import com.example.demo_jwt.model.category.Product;
import com.example.demo_jwt.repository.category.ProductRepository;
import com.example.demo_jwt.service.category.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(Product product,Long id) {
        return productRepository.update(product.getNameProduct(), product.getPrice(), product.getStatus(), id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.findByNameProductContaining(name, pageable);
    }
}
