package com.myWebsite.controller.web;

import com.myWebsite.entity.Category;
import com.myWebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView myPage(){
        List<Category> categoryList=categoryService.getAll();
        for(Category category:categoryList){
            System.out.println(category.getName());
        }
        System.out.println("home Page");
        ModelAndView mav=new ModelAndView("web/home");
        return mav;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(){
        Category category=new Category();
        category.setName("Văn Hóa");
        category.setCode("VH");

        return categoryService.save(category).getId().toString();
    }

}
