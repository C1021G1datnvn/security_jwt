package com.example.demo_jwt.repository.category;

import com.example.demo_jwt.model.category.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
}
