package com.myWebsite.service.Interface;

import com.myWebsite.entity.TypeApartment;
import com.myWebsite.reposity.TypeApartmentReposity;

import java.util.List;

public interface TypeApartmentService {
    List<TypeApartment> findAll();
    TypeApartment findById(Long id);
}
