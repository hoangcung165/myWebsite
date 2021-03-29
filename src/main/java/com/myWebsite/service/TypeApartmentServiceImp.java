package com.myWebsite.service;

import com.myWebsite.entity.TypeApartment;
import com.myWebsite.reposity.TypeApartmentReposity;
import com.myWebsite.service.Interface.TypeApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TypeApartmentServiceImp implements TypeApartmentService {

    @Autowired
    private TypeApartmentReposity typeApartmentReposity;
    @Override
    public List<TypeApartment> findAll() {
        return typeApartmentReposity.findAll();
    }
}
