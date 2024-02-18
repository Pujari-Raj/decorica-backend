package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAllBrand();

    BrandDto findByBrandId(Long id);

    BaseResponse createOrUpdateBrand(BrandDto brandMasterDto);

    BaseResponse deleteBrandById(Long id);
}
