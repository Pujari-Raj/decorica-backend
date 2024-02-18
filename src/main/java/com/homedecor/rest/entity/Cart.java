package com.homedecor.rest.entity;


import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cart")
public class Cart  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="cart_id")
    private Long cart_id;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductMaster productMaster;
    public ProductMaster getProductMaster() {
        return this.productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
    public Long getCartId() {
        return cart_id;
    }

    public void setCartId(Long cartId) {
        this.cart_id = cartId;
    }

    public Integer getCartQuantity() {
        return quantity;
    }

    public void setCartQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

