package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId_UserId(Long userId);

    void deleteByProductMaster_ProductId(Long productId);
}