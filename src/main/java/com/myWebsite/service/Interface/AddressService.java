package com.myWebsite.service.Interface;

import com.myWebsite.entity.Address;

public interface AddressService {
    void save(Address address);
    Address findbyId(Long id);
}
