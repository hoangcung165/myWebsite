package com.myWebsite.service;

import com.myWebsite.entity.Servicehotel;
import com.myWebsite.reposity.ServiceHotelRepository;
import com.myWebsite.service.Interface.ServiceHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ServiceHotelImpl implements ServiceHotelService {
    @Autowired
    private ServiceHotelRepository repository;
    @Override
    public List<Servicehotel> findAll() {
        return repository.findAll();
    }

    @Override
    public Servicehotel findById(Long id) {
        return repository.findById(id).get();
    }
}
