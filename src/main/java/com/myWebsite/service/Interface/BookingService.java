package com.myWebsite.service.Interface;

import com.myWebsite.dto.bookingFormDTO;
import com.myWebsite.entity.Booking;

import java.text.ParseException;
import java.util.List;

public interface BookingService {
    boolean save(bookingFormDTO formDTO) throws ParseException;
    List<Booking> findAllByAuthorize();
    List<Booking> findAllByApartment(Long id);
    int countBookingByApartmentIdAndStatus(Long id,int status);
    List<Booking> findBookingsByApartmentIdAndStatus(Long id,int status);
//    Booking findById(Long id);
    boolean acceptBooking(Long id);
}
