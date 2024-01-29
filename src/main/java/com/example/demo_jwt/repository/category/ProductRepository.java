package com.example.demo_jwt.repository.category;

import com.example.demo_jwt.model.category.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameProductContaining(String name, Pageable pageable);

    @Query(value = "Update product set name_product = ?1, price = ?2, status = ?3, where id = ?4", nativeQuery = true)
    Product update(String name_product, Double price, String status, Long id);

}
