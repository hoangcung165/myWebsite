package com.myWebsite.service;

import com.myWebsite.entity.HaveService;
import com.myWebsite.reposity.HaveServiceReposity;
import com.myWebsite.service.Interface.HaveServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HaveServiceImpl implements HaveServiceS {
    @Autowired
    HaveServiceReposity reposity;
    @Override
    public void save(HaveService haveService) {
        reposity.save(haveService);
    }

    @Override
    public List<HaveService> findAllByApartmentID(Long id) {
        return reposity.findAllByApartmentHave_Id(id);
    }
}
