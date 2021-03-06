package com.myWebsite.controller.web;


import com.myWebsite.dto.*;
import com.myWebsite.entity.*;
import com.myWebsite.service.Interface.*;
import com.myWebsite.utils.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class HomeController {


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
    ServletContext servletContext;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HaveServiceS haveServiceS;
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView myPage(@RequestParam(value = "program",required = false) String program, Authentication authentication){
        ModelAndView mav=new ModelAndView("web/home");
        if(program!=null){
            String error="";
            if(program.equals("denied")){
                error="denied";
            }
            mav.addObject("error",error);
        }
        if(authentication!=null){
            System.out.println("have authencation");
            MyUser myUser=SecurityUtils.getPrincial();
            System.out.println(myUser.getFullName());
            mav.addObject("user",myUser);
        }
        List<devvn_tinhthanhpho> devvn_tinhthanhphoList=tinhService.getAll();
        mav.addObject("listTinhThanh",devvn_tinhthanhphoList);


        return mav;
    }
    @RequestMapping(value = "/accessDenied" )
    public String DenielPage(@RequestParam(value = "denied",required = false) String denied, Authentication authentication){

        List<String> roles= SecurityUtils.getAuthorites();
        System.out.println(roles.get(0));
        if(!roles.contains("ROLE_MANAGER")){
            return "redirect:/confirm";
        }

        return "redirect:/home?program=denied";
    }



    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) final String error,
                                  @RequestParam(value = "registed", required = false) final String registed,
                                  HttpServletRequest request,
                                  final Model model){
        if(request!=null && request.getHeader("Referer")!=null){
            String referrer=request.getHeader("Referer");
            System.out.println(referrer);
            if(!referrer.contains("login") && referrer!=null && !referrer.contains("register")){
                request.getSession().setAttribute("url_prior_login",referrer);
                System.out.println(referrer);
            }
        }

        String message="";
        if (error != null) {
            message="Login faild";
        }
        if(registed!=null){
            message="Wellcome";
        }

        ModelAndView mav=new ModelAndView("login/loginPage");
        mav.addObject("mess",message);
        return mav;
    }


    @RequestMapping("/logout")
    public String logout(final Model model){
        System.out.println("out");
        model.addAttribute("message","logout");
        return "web/home";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(){
        List<devvn_tinhthanhpho> listTinh=tinhService.getAll();
        ModelAndView modelAndView=new ModelAndView("web/register");
        modelAndView.addObject("listT",listTinh);
        return modelAndView;
    }
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("formRegister")formRegister formRegister) throws ParseException {
        registerService.register(formRegister);
        return "redirect:/login?registed=success";

    }

    @GetMapping(value = "/testRoot")
    public String testRoot(@SessionAttribute("booking") String booking)  {
        System.out.println(booking);
        return "redirect:/";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ModelAndView test(@RequestParam("detail")String detail){
        ModelAndView modelAndView=new ModelAndView("web/home");
        modelAndView.addObject("detail",detail);
        return modelAndView;
    }

    @RequestMapping(value = "/upfile")
    public String upfile(){
        return "web/test";
    }

    @RequestMapping(value = "/profile")
    public ModelAndView profile(Authentication authentication){
        if(authentication!=null){
            MyUser myUser=SecurityUtils.getPrincial();
            System.out.println(myUser.getUser_id());
            ModelAndView mad=new ModelAndView("web/profile");
            List<devvn_tinhthanhpho> listTinh=tinhService.getAll();
            mad.addObject("userProfile",personService.findById(myUser.getUser_id()));
            mad.addObject("listT",listTinh);
            return mad;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/confirm")
    public String confirmPage(){
        return "web/confirm";
    }


    @RequestMapping(value = "/updateAvatar",method = RequestMethod.POST)
    public String uploadAvatar(@RequestParam("user_id") Long id,@RequestParam("avatar")CommonsMultipartFile file){
        if(personService.updateAvatar(id,file)){
            return "redirect:/profile";
        }
        return "redirect:/profile?error";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateID(@ModelAttribute("userUpdate")UserUpdateInfor userUpdateInfor){
        try {
            personService.updateInformattion(userUpdateInfor);
            return "redirect:/profile?change=success";
        } catch (ParseException e) {
            return "redirect:/profile?profile?change=fail";
        }
    }

    @RequestMapping(value = "/changePassword")
    public ModelAndView changePassword(){
        ModelAndView modelAndView=new ModelAndView("web/changePassword");

        return modelAndView;
    }

    @RequestMapping(value = "/changePassword/change",method = RequestMethod.POST)
    public String changePasswordPOST(@ModelAttribute("changePassword")ChangePassword password){
        ModelAndView modelAndView=new ModelAndView("redirect:/profile");
        String changePass="";
        if(personService.changePassword(password)){

            return "redirect:/profile?change=success";
        }


        return "redirect:/profile?change=fail";
    }

    @RequestMapping(value = "/getAll")
    public ModelAndView getAll(){
        List<Apartment> apartmentList=apartmentService.findAll();
        ModelAndView modelAndView=new ModelAndView("web/listAll");
        modelAndView.addObject("listApartment",apartmentList);
        return modelAndView;
    }
//    public
    @RequestMapping(value = "getDetail/{id}")
    public ModelAndView viewDetail(@PathVariable("id") String id){
        Long id_hotel=Long.parseLong(id);
        Apartment apartment=apartmentService.findById(id_hotel);
        List<Image> imageList=imageService.findAllByApartmentId(id_hotel);
        List<Room> rooms=roomService.findAllbyApartId(id_hotel);
        List<HaveService> haveServiceList=haveServiceS.findAllByApartmentID(id_hotel);
        System.out.println(id);
        ModelAndView modelAndView=new ModelAndView("web/detail");
        modelAndView.addObject("apartment",apartment);
        modelAndView.addObject("imgs",imageList);
        modelAndView.addObject("rooms",rooms);
        modelAndView.addObject("services",haveServiceList);
        return  modelAndView;
    }
    @RequestMapping(value = "listApartment/{type_id}")
    public ModelAndView filterByType(@PathVariable("type_id") Long typeId){
        List<Apartment> apartments=apartmentService.findAllbyType(typeId);


        ModelAndView modelAndView=new ModelAndView("web/listAll");
        modelAndView.addObject("listApartment",apartments);
        return modelAndView;
    }
    @RequestMapping(value = "/listApartmentByTinh")
    public ModelAndView filbyTinh(@ModelAttribute("preBooking") preBooking booking, HttpServletRequest request){

        List<Apartment> apartments=apartmentService.findAllbyAddress(booking.getId_TinhThanh());


        ModelAndView modelAndView=new ModelAndView("web/listAll");
        modelAndView.addObject("listApartment",apartments);
        HttpSession session=request.getSession();
        session.setAttribute("booking",booking);
        return modelAndView;

//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date1=dateFormat.parse(booking.getBeginDate());
//            Date date2=dateFormat.parse(booking.getEndDate());
//            long diff=date2.getTime()-date1.getTime();
//            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//            int dates=(int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//            out.setDates(dates);
//            out.setQtyRoomMax(booking.getQty_customer());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(booking);
//        System.out.println(out);
//        HttpSession session=request.getSession();
//        session.setAttribute("booking",booking);
//        return out;
    }
    @RequestMapping(value = "/listApartmentByTinh/{tinh_id}")
    public ModelAndView findbyTinh(@PathVariable("tinh_id")String tinhId){

        List<Apartment> apartments=apartmentService.findAllbyAddress(tinhId);


        ModelAndView modelAndView=new ModelAndView("web/listAll");
        modelAndView.addObject("listApartment",apartments);
//
        return modelAndView;

    }

}
