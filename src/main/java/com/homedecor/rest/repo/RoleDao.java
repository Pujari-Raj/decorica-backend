package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAllRoles();

    boolean existsById(Long id);

    Role findById(Long id);
}
