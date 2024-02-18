package com.homedecor.rest.dto;

import com.homedecor.rest.entity.ProductMaster;

public class WishlistProductDTO {
    private Long wishlistId;
    private ProductMasterDto product;

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public ProductMasterDto getProduct() {
        return product;
    }

    public void setProduct(ProductMasterDto product) {
        this.product = product;
    }
}
