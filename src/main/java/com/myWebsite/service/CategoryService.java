package com.myWebsite.service;

import com.myWebsite.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category save(Category category);
}
