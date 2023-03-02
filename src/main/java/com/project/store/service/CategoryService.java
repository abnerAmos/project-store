package com.project.store.service;

import com.project.store.model.Category;
import com.project.store.model.User;
import com.project.store.repository.CategoryRepository;
import com.project.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
