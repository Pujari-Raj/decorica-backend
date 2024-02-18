package com.homedecor.rest.repo;


import com.homedecor.rest.entity.Cart;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.Wishlist;

import java.util.List;
import java.util.Optional;

public interface ProductMasterDao {
    List<ProductMaster> findAllProducts();

    ProductMaster findById(Long id);

    boolean existsById(Long id);

    void save(ProductMaster ProductMaster);

    void deleteById(Long id);

    List<ProductMaster> findByuserId(Long userId);

    Wishlist saveWishlist(Wishlist wishlist);

    List<Wishlist> findByUserId_UserId(Long userId);

    void deleteByProductMaster_ProductId(Long productId);

    void saveCart(Cart cartItem);

    void deleteCartById(Long cartId);

    List<Cart> findCartByUserId(Long userId);

    Optional<Cart> findByCartId(Long cartId);
}

