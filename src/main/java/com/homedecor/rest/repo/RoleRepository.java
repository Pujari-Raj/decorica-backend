package com.homedecor.rest.repo;

import com.homedecor.rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    Role findByRoleId(Long id);
}