package com.project.store.controller;

import com.project.store.model.Product;
import com.project.store.repository.ProductRepository;
import com.project.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> user = productRepository.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
