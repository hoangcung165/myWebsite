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

    @Override
    public boolean save(Bed bed) {
        try {
            bedReposity.save(bed);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean deletebyID(Long id) {
        try{
            bedReposity.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateBed(Long id, String newName) {
        Bed bed=bedReposity.findById(id).get();
        bed.setTypeName(newName);

        return save(bed);
    }
}
