package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;
import com.homedecor.rest.entity.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemsRepo extends JpaRepository<ProductItems, Long> {

    public boolean existsById(Long id);
    void deleteById(Long id);
    ProductItems findByProductItemsId(Long id);
}
