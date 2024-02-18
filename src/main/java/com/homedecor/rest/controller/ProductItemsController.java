package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.ProductItemsDto;
import com.homedecor.rest.service.ProductItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/secured/ProductItems")
@CrossOrigin(origins = "*")
public class ProductItemsController {

    @Autowired
    private ProductItemsService productItemsService;

    @GetMapping(value = "/getAllProductItems")
    public ResponseEntity<List<ProductItemsDto>> getAllProductItems() {
        List<ProductItemsDto> list = productItemsService.getAllProductItems();
        return new ResponseEntity<List<ProductItemsDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<ProductItemsDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        ProductItemsDto list = productItemsService.findByProductItemsId(id);
        return new ResponseEntity<ProductItemsDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = {"/add", "/update"})
    public ResponseEntity<BaseResponse> createOrUpdateProductItems(@RequestBody ProductItemsDto ProductItemsMasterDto) {
        BaseResponse response = productItemsService.createOrUpdateProductItems(ProductItemsMasterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
        BaseResponse response = productItemsService.deleteProductItemsById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
