package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.RoleDto;
import com.homedecor.rest.entity.Role;
import com.homedecor.rest.repo.RoleDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public List<RoleDto> getAllRoles() {
        return roleDao.findAllRoles().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto findByRoleId(Long id) {
        if (roleDao.existsById(id)) {
            Role role = roleDao.findById(id);
            return copyEntityToDto(role);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }


    private RoleDto copyEntityToDto(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);
        return roleDto;
    }

    private Role copyDtoToEntity(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        return role;
    }
}
