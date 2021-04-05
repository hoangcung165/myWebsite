package com.myWebsite.controller.web;

import com.myWebsite.dto.MyUser;
import com.myWebsite.dto.preBooking;
import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Person;
import com.myWebsite.entity.Room;
import com.myWebsite.service.Interface.ApartmentService;
import com.myWebsite.service.Interface.PersonService;
import com.myWebsite.service.Interface.RoomService;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@SessionAttributes("booking")
public class booking {
    @Autowired
    private PersonService personService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private RoomService roomService;
//    @RequestMapping(value = "/checkAvailable",method = RequestMethod.POST)
//    public ModelAndView checkAvailable(@ModelAttribute("preBooking") preBooking booking, HttpServletRequest request){
//        System.out.println(booking.getBeginDate());
//        String referrer=request.getHeader("Referer");
//        System.out.println(referrer);
//        ModelAndView modelAndView=new ModelAndView("redirect:"+referrer);
//        modelAndView.addObject("booking",booking);
//
//        return modelAndView;
//    }

    @RequestMapping(value = "/booking/{apartment_id}/{room_id}")
    public ModelAndView booking(HttpServletRequest request,@PathVariable("apartment_id")String apartment_id,@PathVariable("room_id")String room_id){
        System.out.println(apartment_id);
        System.out.println(room_id);
        if (request.getSession().getAttribute("booking")==null){
            return new ModelAndView("redirect:"+request.getHeader("Referer")+"?formBooking=none");
        }
        MyUser myUser= SecurityUtils.getPrincial();
        Person person=personService.findById(myUser.getUser_id());
        Apartment apartment=apartmentService.findById((Long) Long.parseLong(apartment_id));
        Room room= roomService.findById((Long) Long.parseLong(room_id));
        ModelAndView modelAndView=new ModelAndView("web/formCheckOut");
        modelAndView.addObject("person",person);
        modelAndView.addObject("apartment",apartment);
        modelAndView.addObject("room",room);
        return modelAndView;
    }
}
