package com.alura.challenge.resource;

import com.alura.challenge.entity.Category;
import com.alura.challenge.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "categorias")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categoryList , HttpStatus.OK);
    }
}
