package com.homedecor.rest.service;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.UserDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto findByCategoryId(Long id);
    BaseResponse createOrUpdateCategory(CategoryDto categoryDto);
    BaseResponse deleteCategoryById(Long id);
}
