package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;
import com.homedecor.rest.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
    public boolean existsById(Long id);
    void deleteById(Long id);
    Brand findByBrandId(Long id);
}
