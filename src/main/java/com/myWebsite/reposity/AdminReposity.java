package com.myWebsite.reposity;

import com.myWebsite.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminReposity extends CrudRepository<Admin,Long> {
}
