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

    public Category createCategory(Category category){
        return categoryRepository.save(new Category(category.getTitle(), category.getColor()));
    }

    public void deleteCategory(Long id){
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }

    public Category editCategory(Category category ,Long id){
        Category editeCategory = getCategoryById(id);

        editeCategory.setTitle(category.getTitle());
        editeCategory.setColor(category.getColor());

        return categoryRepository.save(editeCategory);
    }
}
