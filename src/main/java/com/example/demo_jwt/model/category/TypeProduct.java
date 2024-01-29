package com.example.demo_jwt.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " type_product")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTypeProduct;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    private Set<Product> products;
}
