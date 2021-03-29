package com.myWebsite.reposity;

import com.myWebsite.entity.HaveService;
import com.myWebsite.entity.Servicehotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HaveServiceReposity extends JpaRepository<HaveService,Long> {
    List<HaveService> findAllByApartmentHave_Id(Long id);
}
