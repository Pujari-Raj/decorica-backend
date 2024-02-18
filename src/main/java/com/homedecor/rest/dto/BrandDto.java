package com.homedecor.rest.dto;

import com.homedecor.rest.entity.User;

import java.util.Date;

public class BrandDto {

	private Integer brandId;
	private User userByModifiedBy;
	private User userByCreatedBy;
	private String brandName;
	private Boolean status;
	private String logo;
	private Integer sortOrder;
	private String website;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public void setUserByModifiedBy(User userByModifiedBy) {
		this.userByModifiedBy = userByModifiedBy;
	}

	public void setUserByCreatedBy(User userByCreatedBy) {
		this.userByCreatedBy = userByCreatedBy;
	}







	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}





	
}
