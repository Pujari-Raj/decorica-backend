package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    public boolean existsById(Long id);

    Category findByCategoryId(Long id);
}
