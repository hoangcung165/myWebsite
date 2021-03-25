package com.myWebsite.service;

import com.myWebsite.entity.devvn_tinhthanhpho;
import com.myWebsite.reposity.devvn_tinhthanhphoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TinhServiceImpl implements TinhService{
    @Autowired
    devvn_tinhthanhphoReposity reposity;
    @Override
    public List<devvn_tinhthanhpho> getAll() {
        return reposity.findAll();
    }

    @Override
    public devvn_tinhthanhpho findById(String id) {

        return reposity.findByMatp(id);
    }
}
