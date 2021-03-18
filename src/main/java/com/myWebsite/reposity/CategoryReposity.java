package com.myWebsite.reposity;

import com.myWebsite.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryReposity extends CrudRepository<Category, Long> {
}
