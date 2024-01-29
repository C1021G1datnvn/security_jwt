package com.example.demo_jwt.controller.category;

import com.example.demo_jwt.model.category.Product;
import com.example.demo_jwt.service.category.IProductService;
import com.example.demo_jwt.service.category.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> list( Pageable pageable) {
        try {
            return ResponseEntity.ok().body(productService.findAll(pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "No content", e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContinent(@RequestBody Product product) {
        try {
            productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Create successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad request", e);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateContinent(@RequestBody Product product, @PathVariable Long id) {

        Product product1 = productService.findById(id);
        if (product1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        try {
            productService.update(product, id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Update successfully");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad request", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLanguages(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not found");
        } else {
            productService.remove(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Delete successfully");
        }
    }
}
