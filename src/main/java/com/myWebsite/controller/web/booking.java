package com.myWebsite.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("booking")
public class booking {
    @RequestMapping(value = "/booking")
    public ModelAndView booking(@RequestParam("detail") String a){
        ModelAndView modelAndView=new ModelAndView("redirect:/");
        modelAndView.addObject("booking",a);
        System.out.println(a);
        return modelAndView;
    }
}
