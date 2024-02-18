package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Cart;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.User;
import com.homedecor.rest.entity.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductMasterDaoImpl implements ProductMasterDao {
    @Autowired
    ProductMasterRepo productMasterRepo;

    @Autowired
    WishlistRepository wishlistRepository;

    @Autowired
    CartRepo cartRepo;


    @Override
    public List<ProductMaster> findAllProducts() {
        return productMasterRepo.findAll();
    }

    @Override
    public ProductMaster findById(Long id) {
        return productMasterRepo.findByProductId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productMasterRepo.existsById(id);
    }

    @Override
    public void save(ProductMaster ProductMaster) {
        productMasterRepo.save(ProductMaster);
    }

    @Override
    public void deleteById(Long id) {
        productMasterRepo.deleteById(id);
    }

    @Override
    public List<ProductMaster> findByuserId(Long userId) {
        User user = new User();
        user.setUserId(userId);
        return productMasterRepo.findByUserId(user);
    }

    @Override
    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> findByUserId_UserId(Long userId) {
        return wishlistRepository.findByUserId_UserId(userId);
    }

    @Override
    public void deleteByProductMaster_ProductId(Long productId) {
        wishlistRepository.deleteByProductMaster_ProductId(productId);
    }

    @Override
    public void saveCart(Cart cartItem) {
        cartRepo.save(cartItem);
    }

    @Override
    public void deleteCartById(Long cartId) {
        cartRepo.deleteById(cartId);
    }

    @Override
    public List<Cart> findCartByUserId(Long userId) {
        return cartRepo.findByUserId_UserId(userId);
    }

    @Override
    public Optional<Cart> findByCartId(Long cartId) {
        return cartRepo.findById(cartId);
    }
}



