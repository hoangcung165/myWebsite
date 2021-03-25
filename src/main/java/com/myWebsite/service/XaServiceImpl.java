package com.myWebsite.service;

import com.myWebsite.entity.devvn_xaphuongthitran;
import com.myWebsite.reposity.devvn_xaphuongthitranReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class XaServiceImpl implements XaService{
    @Autowired
    devvn_xaphuongthitranReposity reposity;

    @Override
    public List<devvn_xaphuongthitran> getAll() {
        return (List<devvn_xaphuongthitran>) reposity.findAll();
    }

    @Override
    public List<devvn_xaphuongthitran> findByhuyen(String huyenId) {
        return reposity.findAllByMaqh(huyenId);
    }

    @Override
    public devvn_xaphuongthitran findById(String id) {
        return reposity.findByXaid(id);
    }
}
