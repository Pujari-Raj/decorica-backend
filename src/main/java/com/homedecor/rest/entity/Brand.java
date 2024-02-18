
package com.homedecor.rest.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "brand")
public class Brand implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer brandId;
    private User userByModifiedBy;
    private User userByCreatedBy;
    private String brandName;
    private Boolean status;
    private String logo;
    private Integer sortOrder;
    private String website;
    private Set<ProductMaster> productMasters = new HashSet<ProductMaster>(0);

    public Brand() {
    }

    public Brand(User userByModifiedBy, User userByCreatedBy, String brandName,
                 Boolean status, String logo, Integer sortOrder, String website,
                 Date createdOn, Date modifiedOn, Set<ProductMaster> productMasters) {
        this.userByModifiedBy = userByModifiedBy;
        this.userByCreatedBy = userByCreatedBy;
        this.brandName = brandName;
        this.status = status;
        this.logo = logo;
        this.sortOrder = sortOrder;
        this.website = website;
        this.productMasters = productMasters;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    public Integer getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modified_by")
    public User getUserByModifiedBy() {
        return this.userByModifiedBy;
    }

    public void setUserByModifiedBy(User userByModifiedBy) {
        this.userByModifiedBy = userByModifiedBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    public User getUserByCreatedBy() {
        return this.userByCreatedBy;
    }

    public void setUserByCreatedBy(User userByCreatedBy) {
        this.userByCreatedBy = userByCreatedBy;
    }

    @Column(name = "brand_name", length = 125)
    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Column(name = "logo", length = 125)
    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Column(name = "website", length = 225)
    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    public Set<ProductMaster> getProductMasters() {
        return this.productMasters;
    }

    public void setProductMasters(Set<ProductMaster> productMasters) {
        this.productMasters = productMasters;
    }

}

