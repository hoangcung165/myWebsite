package com.myWebsite.service;

import com.myWebsite.dto.MyUser;
import com.myWebsite.dto.bookingFormDTO;
import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Booking;
import com.myWebsite.entity.Person;
import com.myWebsite.entity.Room;
import com.myWebsite.reposity.BookingReposity;
import com.myWebsite.service.Interface.ApartmentService;
import com.myWebsite.service.Interface.BookingService;
import com.myWebsite.service.Interface.PersonService;
import com.myWebsite.service.Interface.RoomService;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingReposity bookingReposity;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private PersonService personService;

    @Override
    public boolean save(bookingFormDTO formDTO) throws ParseException {
        try{
            Booking booking=new Booking();
            booking.setApartment(findApartment(formDTO.getApartment_id()));
            booking.setRoom(findRoom(formDTO.getRoom_id()));
            booking.setBegin(dateFormate(formDTO.getBeginDate()));
            booking.setFinish(dateFormate(formDTO.getEndDate()));
            booking.setCustomer(findPerson());
            booking.setPay(formDTO.getPayment());
            booking.setQty_customer(formDTO.getQty_Cus());
            booking.setQty_room(formDTO.getQty_Room());
            booking.setStatus(2);
            bookingReposity.save(booking);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Booking> findAllByAuthorize() {
        MyUser myUser=SecurityUtils.getPrincial();
        return bookingReposity.findBookingsByCustomerId(myUser.getUser_id());
    }

    @Override
    public List<Booking> findAllByApartment(Long id) {
        return null;
    }

    @Override
    public int countBookingByApartmentIdAndStatus(Long id, int status) {
        return bookingReposity.countBookingByApartmentIdAndStatus(id,status);
    }

    @Override
    public List<Booking> findBookingsByApartmentIdAndStatus(Long id, int status) {
        return bookingReposity.findBookingsByApartmentIdAndStatus(id,status);
    }

//    @Override
//    public Booking findById(Long id) {
//        return bookingReposity.findById(id).get();
//    }
//
    @Override
    public boolean acceptBooking(Long id) {
        try{
            Booking booking=bookingReposity.findById(id).get();
            booking.setStatus(1);
            bookingReposity.save(booking);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }


    private Apartment findApartment(Long id){
        return apartmentService.findById(id);
    }
    private Room findRoom(Long id){
        return roomService.findById(id);
    }
    private Date dateFormate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(date);
    }
    private Person findPerson(){
        MyUser myUser=SecurityUtils.getPrincial();
        return personService.findById(myUser.getUser_id());
    }

}
