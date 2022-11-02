package com.alura.challenge.service;

import com.alura.challenge.entity.Category;
import com.alura.challenge.exception.ObjectNotFoundException;
import com.alura.challenge.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada pelo id:" + id));
    }
}
