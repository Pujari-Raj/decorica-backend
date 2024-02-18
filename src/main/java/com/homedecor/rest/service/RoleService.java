package com.homedecor.rest.service;

import com.homedecor.rest.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();

    RoleDto findByRoleId(Long id);
}
