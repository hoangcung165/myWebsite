package com.myWebsite.controller.web;

import com.myWebsite.dto.MyUser;
import com.myWebsite.entity.*;
import com.myWebsite.service.Interface.*;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
