package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.BrandDto;
import com.homedecor.rest.entity.Brand;
import com.homedecor.rest.repo.BrandDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandDao brandDao;

    @Override
    public List<BrandDto> getAllBrand() {
        return brandDao.findAllBrands().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public BrandDto findByBrandId(Long id) {
        if (brandDao.existsById(id)) {
            Brand brand = brandDao.findById(id);
            return copyEntityToDto(brand);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse deleteBrandById(Long id) {
        if (brandDao.existsById(id)) {
            brandDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse createOrUpdateBrand(BrandDto brandDto) {
        try {
            Brand BrandMaster = copyDtoToEntity(brandDto);
            brandDao.save(BrandMaster);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.BRAND_SAVE_SUCCESS_MESSAGE);
    }

    private BrandDto copyEntityToDto(Brand BrandMaster) {
        BrandDto BrandDto = new BrandDto();
        BeanUtils.copyProperties(BrandMaster, BrandDto);
        return BrandDto;
    }

    private Brand copyDtoToEntity(BrandDto brandDto) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandDto, brand);
        return brand;
    }

}
