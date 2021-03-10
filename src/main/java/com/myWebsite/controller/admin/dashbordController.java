package com.myWebsite.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dashbordController {

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public ModelAndView adminPgae(){
        ModelAndView mav=new ModelAndView("admin/dashbord");
        return mav;
    }
}
