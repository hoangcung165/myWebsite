package com.myWebsite.reposity;

import com.myWebsite.entity.HaveService;
import com.myWebsite.entity.Servicehotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceHotelRepository extends JpaRepository<Servicehotel,Long> {
    Servicehotel findAllByHaveService(HaveService haveService);

}
