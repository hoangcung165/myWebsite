package com.myWebsite.controller.web;


import com.myWebsite.entity.*;
import com.myWebsite.reposity.PersonReposity;
import com.myWebsite.reposity.RoomNameReposity;
import com.myWebsite.service.CategoryService;
import com.myWebsite.service.RoomService;
import com.myWebsite.service.TypeRoomService;
import com.myWebsite.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TypeRoomService typeRoomService;






    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView myPage(){
//        List<Category> categoryList=categoryService.getAll();
//        for(Category category:categoryList){
//            System.out.println(category.getName());
//        }
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

//        TypeRoom typeRoom=typeRoomService.findByID(1L);
//        System.out.println(typeRoom.getType());
//        RoomName roomName=typeRoom.getRoomNames().get(0);
//        System.out.println(roomName.getName());
//        Room room=new Room();
//        room.setSize(235);
//        room.setTypeRoom(typeRoom);
//        room.setRoomName(roomName);
//
//        roomService.save(room);


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
        model.addAttribute("message","logout");
        return "login";
    }


    @RequestMapping("/admin")
    public String adminPgae() {
        return "admin/dashbord";
    }

//    @RequestMapping(value = "/test",method = RequestMethod.POST)
//    public String test(@ModelAttribute("formUser") Person person){
//        return "web/home";
//    }
}
