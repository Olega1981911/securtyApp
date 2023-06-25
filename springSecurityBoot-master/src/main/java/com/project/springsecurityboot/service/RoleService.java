package com.project.springsecurityboot.service;

import com.project.springsecurityboot.models.Role;

import java.util.List;


public interface RoleService {
    void save(Role role);

    List<Role> getAllRoles();

    Role getOneRole(Long id);
}
