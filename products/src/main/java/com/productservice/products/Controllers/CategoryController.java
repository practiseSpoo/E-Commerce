package com.productservice.products.Controllers;

import com.productservice.products.models.Category;
import com.productservice.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/category")
    public Category getCategory(){
         return null;
    }
}
