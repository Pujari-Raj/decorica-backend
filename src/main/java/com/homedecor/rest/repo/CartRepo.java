package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Cart;
import com.homedecor.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId_UserId(Long userId);
}