package com.myWebsite.service;

import com.myWebsite.entity.Address;
import com.myWebsite.reposity.AddressReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressReposity addressReposity;
    @Override
    public void save(Address address) {
        addressReposity.save(address);
    }

    @Override
    public Address findbyId(Long id) {
        return addressReposity.findById(id).get();
    }

}
