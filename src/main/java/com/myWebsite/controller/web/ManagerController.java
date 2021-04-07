package com.myWebsite.controller.web;

import com.myWebsite.dto.HotelRegister;
import com.myWebsite.dto.MyUser;
import com.myWebsite.dto.RoomDTO;
import com.myWebsite.entity.*;
import com.myWebsite.service.Interface.*;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private TypeRoomService typeRoomService;

    @Autowired
    private RegisterService registerService;


    @Autowired
    private TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private PersonService personService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ImageService imageService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private TypeApartmentService typeApartmentService;
    @Autowired
    private BedService bedService;
    @Autowired
    private ServiceHotelService serviceHotelService;

    @Autowired
    private SaveNewHotelService saveNewHotelService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/manager")
    public ModelAndView managerPage(){
        MyUser myUser= SecurityUtils.getPrincial();
        Person person=personService.findById(myUser.getUser_id());
        Manager manager=managerService.findByPerson(person);
        List<Apartment> apartmentList=apartmentService.findAllByOwner(manager);
        System.out.println(apartmentList.size());

        ModelAndView mad=new ModelAndView("web/manager");
        mad.addObject("listApart",apartmentList);
        return mad;
    }

    @RequestMapping(value = "/registerManager")
    public String registerManager(Authentication authentication){
        if(authentication!=null){
            MyUser myUser= SecurityUtils.getPrincial();
            Person person=personService.findById(myUser.getUser_id());
            System.out.println(person.getName());
            if(registerService.registerManager(person)==true){
                return "redirect:/manager";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/manager/postAppartment")
    public ModelAndView postApartment(){
        MyUser myUser= SecurityUtils.getPrincial();
        Person person=personService.findById(myUser.getUser_id());
        Manager manager=managerService.findByPerson(person);
        List<TypeApartment> typeApartmentList=typeApartmentService.findAll();
        List<devvn_tinhthanhpho> listTinh=tinhService.getAll();
        List<TypeRoom> typeRoomList=typeRoomService.findAll();
        List<Bed> bedList=bedService.findAll();
        List<Servicehotel> servicehotelList=serviceHotelService.findAll();
        ModelAndView modelAndView=new ModelAndView("web/postApartment");
        modelAndView.addObject("manager",manager);
        modelAndView.addObject("user",person);
        modelAndView.addObject("listTypeAp",typeApartmentList);
        modelAndView.addObject("listT",listTinh);
        modelAndView.addObject("listTypeRoom",typeRoomList);
        modelAndView.addObject("listBed",bedList);
        modelAndView.addObject("listService",servicehotelList);
        return modelAndView;

    }

    @RequestMapping(value = "/manager/postNewHotel")
    public String postNewHotel(@ModelAttribute("newHotel")HotelRegister hotelRegister){
        System.out.println(hotelRegister.toString());
        if(saveNewHotelService.saveNewHotel(hotelRegister)){
            System.out.println("Ok");
            return "redirect:/manager";
        }
        System.out.println("cc");
        return "redirect:/";
    }
    @RequestMapping(value = "/manager/{id_apartment}")
    public ModelAndView managerBooking(@PathVariable("id_apartment") Long id){
        List<Booking> bookingsAccept=bookingService.findBookingsByApartmentIdAndStatus(id,1);
        List<Booking> bookingsWait=bookingService.findBookingsByApartmentIdAndStatus(id,2);
        List<Booking> bookingsCancel=bookingService.findBookingsByApartmentIdAndStatus(id,0);
        ModelAndView modelAndView=new ModelAndView("web/managerBooking");
        modelAndView.addObject("accept",bookingsAccept);
        modelAndView.addObject("wait",bookingsWait);
        modelAndView.addObject("cancel",bookingsCancel);
        System.out.println(bookingsAccept.size());
        System.out.println(bookingsWait.size());
        System.out.println(bookingsCancel.size());
        return modelAndView;

    }
    @RequestMapping(value = "/manager/listRoom/{apartment_id}")
    public ModelAndView managerRooms(@PathVariable("apartment_id") Long id){
        List<Room> rooms=roomService.findAllbyApartId(id);
        ModelAndView modelAndView=new ModelAndView("web/managerRoom");
        modelAndView.addObject("rooms",rooms);
        return modelAndView;

    }
    @RequestMapping(value = "/manager/listRoom/addNewRoom/{apartment_id}")
    public ModelAndView addNewRooms(@PathVariable("apartment_id") Long id){
//        List<Room> rooms=roomService.findAllbyApartId(id);
        List<TypeRoom> typeRoomList=typeRoomService.findAll();
        List<Bed> bedList=bedService.findAll();
        ModelAndView modelAndView=new ModelAndView("web/AddRoom");
//        modelAndView.addObject("rooms",rooms);
        modelAndView.addObject("listTypeRoom",typeRoomList);
        modelAndView.addObject("listBed",bedList);

        return modelAndView;

    }
    @RequestMapping(value = "/manager/listRoom/addNewRoom/{apartment_id}",method = RequestMethod.POST)
    public String PostNewRooms(@PathVariable("apartment_id") Long id, @ModelAttribute("NewRoom")RoomDTO roomDTO){

        if(roomService.addNewRoomForApartment(id,roomDTO)){
            return "redirect:/manager/listRoom/"+id;
        }

        return "redirect:/";

    }
    @RequestMapping(value = "/manager/accept/{apartment_id}/{id_booking}")
    public ModelAndView acceptBooking(@PathVariable("id_booking") Long id,@PathVariable("apartment_id") Long apartment_id){

        ModelAndView modelAndView=new ModelAndView("redirect:/manager/"+apartment_id);
        if(bookingService.acceptBooking(id)){
            System.out.println("accept");
            return modelAndView;
        }
        return modelAndView;

    }
    @RequestMapping(value = "/manager/cancel/{apartment_id}/{id_booking}")
    public ModelAndView cancelBooking(@PathVariable("id_booking") Long id,@PathVariable("apartment_id") Long apartment_id){

        ModelAndView modelAndView=new ModelAndView("redirect:/manager/"+apartment_id);
        if(bookingService.cancelBooking(id)){
            System.out.println("cancel");
            return modelAndView;
        }
        return modelAndView;

    }


}
