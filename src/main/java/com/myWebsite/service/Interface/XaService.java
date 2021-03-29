package com.myWebsite.service.Interface;

import com.myWebsite.entity.devvn_xaphuongthitran;

import java.util.List;

public interface XaService {
    List<devvn_xaphuongthitran> getAll();
    List<devvn_xaphuongthitran> findByhuyen(String huyenId);
    devvn_xaphuongthitran findById(String id);
}
