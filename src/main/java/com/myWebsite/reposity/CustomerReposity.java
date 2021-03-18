package com.myWebsite.reposity;

import com.myWebsite.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerReposity extends CrudRepository<Customer,Long> {
}
