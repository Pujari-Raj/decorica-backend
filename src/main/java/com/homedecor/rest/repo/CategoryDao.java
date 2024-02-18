package com.homedecor.rest.repo;


import com.homedecor.rest.entity.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategories();

    Category findById(Long id);

    boolean existsById(Long id);

    void save(Category category);

    void deleteById(Long id);
}

