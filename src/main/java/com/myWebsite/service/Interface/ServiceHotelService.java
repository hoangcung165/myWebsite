package com.myWebsite.service.Interface;

import com.myWebsite.entity.Servicehotel;

import java.util.List;

public interface ServiceHotelService {
    List<Servicehotel> findAll();
    Servicehotel findById(Long id);
}
