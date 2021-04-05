package com.myWebsite.reposity;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingReposity extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByFinishBetween(Date begin,Date finish);
    List<Booking> findBookingsByCustomerId(Long id);
    List<Booking> findBookingsByApartmentId(Long id);
    int countBookingByApartmentIdAndStatus(Long id,int status);
    List<Booking> findBookingsByApartmentIdAndStatus(Long id,int status);
}
