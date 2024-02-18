package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.ProductItemsDto;
import com.homedecor.rest.dto.ProductMasterDto;
import com.homedecor.rest.entity.ProductItems;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.repo.ProductItemsDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductItemsServiceImpl implements ProductItemsService {
    @Autowired
    ProductItemsDao productItemsDao;

    @Override
    public List<ProductItemsDto> getAllProductItems() {
        return productItemsDao.findAllProductItems().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }


    @Override
    public ProductItemsDto findByProductItemsId(Long id) {
        if (productItemsDao.existsById(id)) {
            ProductItems productItems = productItemsDao.findById(id);
            return copyEntityToDto(productItems);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse deleteProductItemsById(Long id) {
        if (productItemsDao.existsById(id)) {
            productItemsDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse createOrUpdateProductItems(ProductItemsDto productItemsDto) {
        try {
            ProductItems ProductItemsMaster = copyDtoToEntity(productItemsDto);
            productItemsDao.save(ProductItemsMaster);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.USER_SAVE_SUCCESS_MESSAGE);
    }

    private ProductItemsDto copyEntityToDto(ProductItems productItems) {
        ProductItemsDto productItemsDto = new ProductItemsDto();
        BeanUtils.copyProperties(productItems, productItemsDto);
        if (productItems.getProductMaster() != null) {
            ProductMasterDto productMasterDto = new ProductMasterDto();
            productMasterDto.setProductId(productItems.getProductMaster().getProductId());
            productMasterDto.setProductName(productItems.getProductMaster().getProductName());
            productItemsDto.setProductMasterDto(productMasterDto);
        }
        return productItemsDto;
    }

    private ProductItems copyDtoToEntity(ProductItemsDto productItemsDto) {
        ProductItems productItems = new ProductItems();
        BeanUtils.copyProperties(productItemsDto, productItems);
        if (productItemsDto.getProductMasterDto() != null) {
            ProductMaster productMaster = new ProductMaster();
            productMaster.setProductId(productItemsDto.getProductMasterDto().getProductId());
            productMaster.setProductName(productItemsDto.getProductMasterDto().getProductName());
            productItems.setProductMaster(productMaster);
        }
        return productItems;
    }

}
