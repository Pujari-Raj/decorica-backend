package com.homedecor.rest.dto;

import com.homedecor.rest.entity.User;

public class ProductMasterDto {


    private Long productId;
    private BrandDto brandDto;
    private CategoryDto categoryDto;
    private String productName;
    private String description;
    private Integer ratings;
    private Boolean status;
    private String productCode;
    private Double price;

    private Double discountPrice;

    private Integer quantity;
    private String size;
    private String imagePath;
    private UserDto userId;




    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BrandDto getBrandDto() {
        return brandDto;
    }

    public void setBrandDto(BrandDto brandDto) {
        this.brandDto = brandDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public UserDto getUserId() {
        return userId;
    }

    public void setUserId(UserDto userId) {
        this.userId = userId;
    }
}
