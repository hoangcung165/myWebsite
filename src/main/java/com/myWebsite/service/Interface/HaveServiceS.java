package com.myWebsite.service.Interface;

import com.myWebsite.entity.HaveService;

import java.util.List;

public interface HaveServiceS {
    void save(HaveService haveService);
    List<HaveService> findAllByApartmentID(Long id);
}
