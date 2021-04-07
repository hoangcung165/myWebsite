package com.myWebsite.service.Interface;

import com.myWebsite.entity.Bed;

import java.util.List;

public interface BedService {
    List<Bed> findAll();
    boolean save(Bed bed);
    boolean deletebyID(Long id);
    boolean updateBed(Long id,String newName);
}
