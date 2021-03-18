package com.myWebsite.controller.web;


import com.myWebsite.entity.Category;
import com.myWebsite.entity.Room;
import com.myWebsite.entity.RoomName;
import com.myWebsite.entity.TypeRoom;
import com.myWebsite.service.CategoryService;
import com.myWebsite.service.RoomService;
import com.myWebsite.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TypeRoomService typeRoomService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView myPage(){
        List<Category> categoryList=categoryService.getAll();
        for(Category category:categoryList){
            System.out.println(category.getName());
        }
        System.out.println("home Page");
        ModelAndView mav=new ModelAndView("web/home");
//
//        RoomName name1=new RoomName();
//        TypeRoom typeRoom=new TypeRoom();
//        name1.setName("A");
//        name1.setTypeRoom(typeRoom);
//        RoomName name2=new RoomName();
//        name2.setName("B");
//        name2.setTypeRoom(typeRoom);
//        RoomName name3=new RoomName();
//        name3.setName("C");
//        name3.setTypeRoom(typeRoom);
//        List<RoomName> roomNameList=new ArrayList<>();
//        roomNameList.add(name1);
//        roomNameList.add(name2);
//        roomNameList.add(name3);
//
//
//        typeRoom.setType("VIP1");
//        typeRoom.setRoomNames(roomNameList);
//
//        typeRoomService.save(typeRoom);

        TypeRoom typeRoom=typeRoomService.findByID(1L);
        System.out.println(typeRoom.getType());
        RoomName roomName=typeRoom.getRoomNames().get(0);
        System.out.println(roomName.getName());
        Room room=new Room();
        room.setSize(235);
        room.setTypeRoom(typeRoom);
        room.setRoomName(roomName);

        roomService.save(room);

        return mav;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(){
        Category category=new Category();
        category.setName("Văn Hóa");
        category.setCode("VH");

        return categoryService.save(category).getId().toString();
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(){
        System.out.println("home Page");
        ModelAndView mav=new ModelAndView("login/loginPage");
        return mav;
    }
}
