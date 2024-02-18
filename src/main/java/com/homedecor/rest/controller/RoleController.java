package com.homedecor.rest.controller;

import com.homedecor.rest.common.exceptions.CustomGenericException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.dto.RoleDto;
import com.homedecor.rest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/secured/role")
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/getAllRoles", method = {RequestMethod.POST, RequestMethod.GET})
    public HashMap<String, Object> getAllRoles() throws Exception {

        try {
            List<RoleDto> roleList = roleService.getAllRoles();
            if (roleList == null || roleList.isEmpty()) {
                throw new CustomGenericException("1009", "No Data");
            }
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("code", "200");
            hashMap.put("Content", roleList);
            return hashMap;
        } catch (CustomGenericException custException) {

            throw custException;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomGenericException("1010", "Server Error");
        }

    }

    @GetMapping(value = "/get/by-id")
    public ResponseEntity<RoleDto> getRoleById(@NotNull(message = "Id can't be null") @RequestParam Long id) {
        RoleDto list = roleService.findByRoleId(id);
        return new ResponseEntity<RoleDto>(list, HttpStatus.OK);
    }


}
