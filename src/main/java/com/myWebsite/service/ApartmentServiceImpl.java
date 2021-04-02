package com.myWebsite.service;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Manager;
import com.myWebsite.reposity.ApartmentReposity;
import com.myWebsite.service.Interface.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    private ApartmentReposity reposity;
    @Override
    public List<Apartment> findAllByOwner(Manager manager) {
        return reposity.findAllByOwner(manager);
    }

    @Override
    public boolean save(Apartment apartment) {
        try{
            reposity.save(apartment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Apartment> findAll() {
        return reposity.findAll();
    }


}
