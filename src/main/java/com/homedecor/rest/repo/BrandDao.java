package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;

import java.util.Collection;

public interface BrandDao {
    Collection<Brand> findAllBrands();

    boolean existsById(Long id);

    Brand findById(Long id);

    void deleteById(Long id);

    void save(Brand brandMaster);
}
