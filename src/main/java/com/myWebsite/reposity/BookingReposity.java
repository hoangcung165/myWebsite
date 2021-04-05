package com.myWebsite.reposity;

import com.myWebsite.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingReposity extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByFinishBetween(Date begin,Date finish);
}
