package com.homedecor.rest.controller;

import com.homedecor.rest.common.exceptions.CustomGenericException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.CategoryDto;
import com.homedecor.rest.dto.UserDto;
import com.homedecor.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/secured/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(value="/getAllCategories",method={RequestMethod.POST,RequestMethod.GET})
    public HashMap<String,Object> getAllCategories() throws Exception{

        try{
            List<CategoryDto> categoryList=categoryService.getAllCategories();
            if(categoryList==null||categoryList.isEmpty()){
                throw new CustomGenericException("1009", "No Data");
            }
            HashMap<String,Object> hashMap=new HashMap<String, Object>();
            hashMap.put("code","200");
            hashMap.put("Content", categoryList);
            return hashMap;
        }
        catch(CustomGenericException custException) {

            throw custException;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new CustomGenericException("1010", "Server Error");
        }

    }
    @GetMapping(value = "/get/by-id")
    public ResponseEntity<CategoryDto> getCategoryById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        CategoryDto list = categoryService.findByCategoryId(id);
        return new ResponseEntity<CategoryDto>(list, HttpStatus.OK);
    }

    @PostMapping(value = { "/add", "/update" })
    public ResponseEntity<BaseResponse> createOrUpdateCategory(@RequestBody CategoryDto categoryDto) {
        BaseResponse response = categoryService.createOrUpdateCategory(categoryDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BaseResponse> deleteCategoryById(@PathVariable("id") Long id) {
        BaseResponse response = categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
