package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl implements BrandDao {
    @Autowired
    BrandRepo brandRepo;


    @Override
    public List<Brand> findAllBrands() {
        return brandRepo.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepo.findByBrandId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return brandRepo.existsById(id);
    }

    @Override
    public void save(Brand brand) {
        brandRepo.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepo.deleteById(id);
    }
}

