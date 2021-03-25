package com.myWebsite.reposity;

import com.myWebsite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleReposity extends JpaRepository<Role,Long> {
    Role findByCode(String code);
}
