package com.myWebsite.reposity;

import com.myWebsite.entity.Servicehotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceHotelRepository extends JpaRepository<Servicehotel,Long> {
}
