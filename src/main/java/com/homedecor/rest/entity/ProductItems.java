package com.homedecor.rest.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product_items")
public class ProductItems implements java.io.Serializable {

    private Long productItemsId;
	private ProductMaster productMaster;
    private Size size;
    private String garmentUniqueCode;
	private Boolean status;
    private Integer quantity;

    public ProductItems() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "productItemsId", unique = true, nullable = false)
    public Long getProductItemsId() {
        return productItemsId;
    }

    public void setProductItemsId(Long productItemsId) {
        this.productItemsId = productItemsId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_master_id")
    public ProductMaster getProductMaster() {
        return this.productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size")
    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Column(name = "garment_unique_code", length = 155)
    public String getGarmentUniqueCode() {
        return this.garmentUniqueCode;
    }

    public void setGarmentUniqueCode(String garmentUniqueCode) {
        this.garmentUniqueCode = garmentUniqueCode;
    }
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private Set<ProductItems> productItemses = new HashSet<ProductItems>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productMaster")
    public Set<ProductItems> getProductItemses() {
        return this.productItemses;
    }

    public void setProductItemses(Set<ProductItems> productItemses) {
        this.productItemses = productItemses;
    }


}
