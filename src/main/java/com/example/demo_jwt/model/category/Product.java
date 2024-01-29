package com.example.demo_jwt.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = " product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;
    private Double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "id")
    private TypeProduct typeProduct;
}
