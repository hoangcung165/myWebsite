package com.myWebsite.reposity;

import com.myWebsite.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerReposity extends JpaRepository<Manager,Long> {
}
