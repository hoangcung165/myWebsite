package com.myWebsite.service;

import com.myWebsite.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findByCode(String code);
}
