package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findByCategoryId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepo.existsById(id);
    }

    @Override
    public void save(Category category) {
         categoryRepo.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}

