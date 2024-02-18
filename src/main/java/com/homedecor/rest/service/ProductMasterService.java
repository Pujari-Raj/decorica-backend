package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.*;
import com.homedecor.rest.entity.Wishlist;

import java.util.List;

public interface ProductMasterService {
    List<ProductMasterDto> getAllProduct();

    ProductMasterDto findByProductId(Long id);

    BaseResponse deleteProductById(Long id);

    BaseResponse createOrUpdateProduct(ProductMasterDto productMasterDto);

    List<ProductMasterDto> getProductByUserId(Long userId);

    Wishlist saveWishlist(WishlistDto wishlistDto);

    List<WishlistProductDTO> getWishlistProductsByUserId(Long userId);

    void deleteWishlistByProductId(Long productId);

    void addToCart(CartRequestDto cartRequest);

    void updateCartItem(CartRequestDto cartRequest);

    void deleteCartItem(Long cartId);

    List<CartItemResponseDto> getUserCart(Long userId);
}
