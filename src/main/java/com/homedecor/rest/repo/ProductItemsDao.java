package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Brand;
import com.homedecor.rest.entity.ProductItems;

import java.util.Collection;

public interface ProductItemsDao {
    
    Collection<ProductItems> findAllProductItems();

    boolean existsById(Long id);

    ProductItems findById(Long id);

    void deleteById(Long id);

    void save(ProductItems productItems);

}
