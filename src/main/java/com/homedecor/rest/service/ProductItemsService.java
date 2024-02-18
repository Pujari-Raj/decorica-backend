package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.BrandDto;
import com.homedecor.rest.dto.ProductItemsDto;

import java.util.List;

public interface ProductItemsService {
    List<ProductItemsDto> getAllProductItems();

    ProductItemsDto findByProductItemsId(Long id);

    BaseResponse createOrUpdateProductItems(ProductItemsDto productItemsDto);

    BaseResponse deleteProductItemsById(Long id);
}
