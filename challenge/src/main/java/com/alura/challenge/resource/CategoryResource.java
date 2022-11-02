package com.alura.challenge.resource;

import com.alura.challenge.entity.Category;
import com.alura.challenge.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categoryList , HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId){
        Category getCategory = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(getCategory , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createNewCategory(@RequestBody Category category){
        Category postCategory = categoryService.createCategory(category);
        return new ResponseEntity<Category>(postCategory , HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> editCategory(@RequestBody  Category category ,@PathVariable Long id){
        Category editCategory = categoryService.editCategory(category , id);
        return new ResponseEntity<Category>(editCategory , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
