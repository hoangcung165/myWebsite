package com.myWebsite.controller.web;

import com.myWebsite.dto.MyUser;
import com.myWebsite.entity.Person;
import com.myWebsite.service.*;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

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

    @RequestMapping(value = "/manager")
    public String managerPage(){
        return "web/manager";
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
}
