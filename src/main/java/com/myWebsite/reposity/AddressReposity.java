package com.myWebsite.reposity;

import com.myWebsite.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReposity extends JpaRepository<Address,Long> {
}
