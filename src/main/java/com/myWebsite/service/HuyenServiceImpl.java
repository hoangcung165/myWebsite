package com.myWebsite.service;

import com.myWebsite.entity.devvn_quanhuyen;
import com.myWebsite.reposity.devvn_quanhuyenReposity;
import com.myWebsite.service.Interface.HuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class HuyenServiceImpl implements HuyenService {
    @Autowired
    devvn_quanhuyenReposity reposity;
    @Override
    public List<devvn_quanhuyen> getAll() {
        return reposity.findAll();
    }

    @Override
    public List<devvn_quanhuyen> findByMatp(String mtp) {
        return reposity.findAllByMatp(mtp);
    }

    @Override
    public devvn_quanhuyen findById(String id) {
        return reposity.findByMaqh(id);
    }


}
