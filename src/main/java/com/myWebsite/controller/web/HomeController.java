package com.myWebsite.controller.web;


import com.myWebsite.entity.*;
import com.myWebsite.reposity.PersonReposity;
import com.myWebsite.reposity.RoomNameReposity;
import com.myWebsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


//    @Autowired
//    private CategoryService categoryService;
//
//    @Autowired
//    private TypeRoomService typeRoomService;




    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView myPage(@RequestParam(value = "program",required = false) String program){
        ModelAndView mav=new ModelAndView("web/home");
        if(program!=null){
            String error="";
            if(program.equals("denied")){
                error="denied";
            }
            mav.addObject("error",error);
        }

        System.out.println("home Page");


        return mav;
    }
    @RequestMapping(value = "/accessDenied" )
    public String DenielPage(@RequestParam(value = "denied",required = false) String denied){
//        if(denied!=null){
//
//        }
//        System.out.println("Error");
//        ModelAndView mav=new ModelAndView("web/home");

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

}
