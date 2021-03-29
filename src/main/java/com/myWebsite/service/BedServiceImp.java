package com.myWebsite.service;

import com.myWebsite.entity.Bed;
import com.myWebsite.reposity.BedReposity;
import com.myWebsite.service.Interface.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class BedServiceImp implements BedService {
    @Autowired
    private BedReposity bedReposity;
    @Override
    public List<Bed> findAll() {
        return bedReposity.findAll();
    }
}
