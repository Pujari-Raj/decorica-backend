package com.homedecor.rest.dto;

// Generated 7 Sep, 2015 11:12:26 AM by Hibernate Tools 3.4.0.CR1

import com.homedecor.rest.entity.ProductItems;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Size generated by hbm2java
 */
@Entity
@Table(name = "size")
public class SizeDto implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2760353231884361712L;
    private Long id;
    private String sizeName;
    private Boolean status;
    private Integer sortOrder;
    private Set<ProductItems> productItemses = new HashSet<ProductItems>(0);

    public SizeDto() {
    }


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "size_name", length = 225)
    public String getSizeName() {
        return this.sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "size")
    public Set<ProductItems> getProductItemses() {
        return this.productItemses;
    }

    public void setProductItemses(Set<ProductItems> productItemses) {
        this.productItemses = productItemses;
    }

}
