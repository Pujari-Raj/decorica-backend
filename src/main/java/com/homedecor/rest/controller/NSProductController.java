package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.*;
import com.homedecor.rest.entity.Wishlist;
import com.homedecor.rest.service.ProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class NSProductController {

    @Autowired
    private ProductMasterService productMasterService;

    @GetMapping(value = "/getAllProduct")
    public ResponseEntity<List<ProductMasterDto>> getAllProduct() {
        List<ProductMasterDto> list = productMasterService.getAllProduct();
        return new ResponseEntity<List<ProductMasterDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<ProductMasterDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        ProductMasterDto list = productMasterService.findByProductId(id);
        return new ResponseEntity<ProductMasterDto>(list, HttpStatus.OK);
    }
}
