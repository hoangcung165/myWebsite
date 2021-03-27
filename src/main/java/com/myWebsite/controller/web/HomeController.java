package com.myWebsite.controller.web;


import com.myWebsite.constant.SystemConstant;
import com.myWebsite.dto.MyUser;
import com.myWebsite.dto.formRegister;
import com.myWebsite.entity.*;
import com.myWebsite.random.RandomString;
import com.myWebsite.service.*;
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
import java.util.*;

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

        System.out.println("home Page");


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
                                  final Model model){
        System.out.println("Login");
        if (error != null) {
            model.addAttribute("message", "Login Failed!");
        }
        ModelAndView mav=new ModelAndView("login/loginPage");
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
        return "redirect:/";

    }
    @RequestMapping(value = "/testRoot")
    public String testRoot(HttpServletRequest request) throws UnsupportedEncodingException {
        RandomString randomString=new RandomString();
        String generatedString =randomString.getAlphaNumericString(10);
        System.out.println(generatedString);
        return "redirect:/";}
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestParam("file")CommonsMultipartFile file, HttpSession session,HttpServletRequest request){
        imageService.uploadImage(file);
        return "redirect:/";
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
            mad.addObject("userProfile",personService.findById(myUser.getUser_id()));
            return mad;
        }
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/manager")
    public String managerPage(){
        return "web/manager";
    }
    @RequestMapping(value = "/confirm")
    public String confirmPage(){
        return "web/confirm";
    }
    @RequestMapping(value = "/registerManager")
    public String registerManager(Authentication authentication){
        if(authentication!=null){
            MyUser myUser=SecurityUtils.getPrincial();
            Person person=personService.findById(myUser.getUser_id());
            System.out.println(person.getName());
            if(registerService.registerManager(person)==true){
                return "redirect:/manager";
            }
        }
        return "redirect:/";
    }


}
