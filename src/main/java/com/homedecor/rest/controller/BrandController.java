package com.homedecor.rest.controller;

import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.BrandDto;
import com.homedecor.rest.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/secured/brand")
@CrossOrigin(origins = "*")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = "/getAllBrand")
    public ResponseEntity<List<BrandDto>> getAllBrand() {
        List<BrandDto> list = brandService.getAllBrand();
        return new ResponseEntity<List<BrandDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<BrandDto> getUserById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        BrandDto list = brandService.findByBrandId(id);
        return new ResponseEntity<BrandDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = {"/add", "/update"})
    public ResponseEntity<BaseResponse> createOrUpdateBrand(@RequestBody BrandDto brandMasterDto) {
        BaseResponse response = brandService.createOrUpdateBrand(brandMasterDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable("id") Long id) {
        BaseResponse response = brandService.deleteBrandById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
