package com.homedecor.rest.dto;

import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.Size;

import java.util.Date;
import java.util.List;

public class ProductItemsDto {

	private Long productItemsId;
	private ProductMasterDto productMasterDto;
	private SizeDto sizeDto;
	private String garmentUniqueCode;
	private Boolean status;
	private Integer quantity;

	public Long getProductItemsId() {
		return productItemsId;
	}

	public void setProductItemsId(Long productItemsId) {
		this.productItemsId = productItemsId;
	}

	public ProductMasterDto getProductMasterDto() {
		return productMasterDto;
	}

	public void setProductMasterDto(ProductMasterDto productMasterDto) {
		this.productMasterDto = productMasterDto;
	}

	public SizeDto getSizeDto() {
		return sizeDto;
	}

	public void setSizeDto(SizeDto sizeDto) {
		this.sizeDto = sizeDto;
	}

	public String getGarmentUniqueCode() {
		return garmentUniqueCode;
	}

	public void setGarmentUniqueCode(String garmentUniqueCode) {
		this.garmentUniqueCode = garmentUniqueCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
