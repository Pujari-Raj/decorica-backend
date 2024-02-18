package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    RoleRepository roleRepo;


    @Override
    public List<Role> findAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepo.findByRoleId(id);
    }

    @Override
    public boolean existsById(Long id) {
        return roleRepo.existsById(id);
    }


}

