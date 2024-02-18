package com.homedecor.rest.repo;

import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductMasterRepo extends JpaRepository<ProductMaster, Long> {
    public boolean existsById(Long id);

    void deleteById(Long id);

    ProductMaster findByProductId(Long id);

    List<ProductMaster> findByUserId(User userId);
}
