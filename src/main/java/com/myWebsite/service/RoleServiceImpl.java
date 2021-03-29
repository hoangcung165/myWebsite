package com.myWebsite.service;

import com.myWebsite.entity.Role;
import com.myWebsite.reposity.RoleReposity;
import com.myWebsite.service.Interface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleReposity reposity;
    @Override
    public List<Role> findAll() {
        return reposity.findAll();
    }

    @Override
    public Role findByCode(String code) {
        return reposity.findByCode(code);
    }
}
