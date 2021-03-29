package com.myWebsite.service.Interface;

import com.myWebsite.entity.devvn_tinhthanhpho;

import java.util.List;
import java.util.Optional;

public interface TinhService {
    List<devvn_tinhthanhpho> getAll();
    devvn_tinhthanhpho findById(String id);
}
