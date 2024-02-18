package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductItemsDaoImpl implements ProductItemsDao {
    @Autowired
    ProductItemsRepo productItemsRepo;


    @Override
    public List<ProductItems> findAllProductItems() {
        return productItemsRepo.findAll();
    }

    @Override
    public ProductItems findById(Long id) {
        return productItemsRepo.findByProductItemsId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productItemsRepo.existsById(id);
    }

    @Override
    public void save(ProductItems productItems) {
         productItemsRepo.save(productItems);
    }

    @Override
    public void deleteById(Long id) {
        productItemsRepo.deleteById(id);
    }
}

