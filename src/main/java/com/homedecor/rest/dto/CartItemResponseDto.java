package com.homedecor.rest.dto;

public class CartItemResponseDto {
    private Long cartId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductMasterDto getProductMasterDto() {
        return productMasterDto;
    }

    public void setProductMasterDto(ProductMasterDto productMasterDto) {
        this.productMasterDto = productMasterDto;
    }

    private Integer quantity;
    private ProductMasterDto productMasterDto;
}
