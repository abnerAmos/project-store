package com.project.store.controller;

import com.project.store.model.Category;
import com.project.store.model.User;
import com.project.store.repository.CategoryRepository;
import com.project.store.repository.UserRepository;
import com.project.store.service.CategoryService;
import com.project.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;



    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> user = categoryRepository.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
