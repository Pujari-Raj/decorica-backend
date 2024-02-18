package com.homedecor.rest.dto;

public class OrderItemDTO {
    private Long productId;
    private Integer quantity;
    private Double price;
    private ProductMasterDto product;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductMasterDto getProduct() {
        return product;
    }

    public void setProduct(ProductMasterDto product) {
        this.product = product;
    }
}