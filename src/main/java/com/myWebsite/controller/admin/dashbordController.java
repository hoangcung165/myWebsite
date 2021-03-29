package com.myWebsite.controller.admin;


import com.myWebsite.entity.Person;
import com.myWebsite.service.Interface.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class dashbordController {
    @Autowired
    PersonService personService;
    @RequestMapping("/admin")
    public ModelAndView adminPgae() {
        System.out.println("admin");
        List<Person> personList=personService.findAll();
        for(Person person:personList){
            System.out.println(person.getName());
        }
        ModelAndView modelAndView=new ModelAndView("admin/dashbord");
        modelAndView.addObject("listUser",personList);

        return modelAndView;
    }
}
