
package com.homedecor.rest.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "wishlist")
public class Wishlist implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    private Long wishlistId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductMaster productMaster;

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public ProductMaster getProductMaster() {
        return productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }
}