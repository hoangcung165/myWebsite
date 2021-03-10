package com.myWebsite.service;

import com.myWebsite.entity.Category;
import com.myWebsite.reposity.CategoryReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryReposity categoryReposity;
    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryReposity.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryReposity.save(category);
    }
}
