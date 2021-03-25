package com.myWebsite.service;

import com.myWebsite.entity.devvn_quanhuyen;
import com.myWebsite.entity.devvn_tinhthanhpho;

import java.util.List;

public interface HuyenService {
    List<devvn_quanhuyen> getAll();
    List<devvn_quanhuyen> findByMatp(String mtp);
    devvn_quanhuyen findById(String id);

}
