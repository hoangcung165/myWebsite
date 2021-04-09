package com.myWebsite.controller.admin;


import com.myWebsite.entity.Bed;
import com.myWebsite.entity.Person;
import com.myWebsite.entity.RoomName;
import com.myWebsite.entity.TypeRoom;
import com.myWebsite.service.Interface.BedService;
import com.myWebsite.service.Interface.PersonService;
import com.myWebsite.service.Interface.RoomNameService;
import com.myWebsite.service.Interface.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class dashbordController {
    @Autowired
    PersonService personService;
    @Autowired
    BedService bedService;
    @Autowired
    private TypeRoomService typeRoomService;
    @Autowired
    private RoomNameService roomNameService;

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
    @RequestMapping(value = "/admin/tableManager")
    public ModelAndView tableManager(){
        ModelAndView modelAndView=new ModelAndView("admin/Table");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/tableManager/Bed")
    public ModelAndView tableManagerBeds(){
        List<Bed> beds=bedService.findAll();
        ModelAndView modelAndView=new ModelAndView("admin/TableObjectBed");
        modelAndView.addObject("beds",beds);
        return modelAndView;
    }
    @RequestMapping(value = "/admin/tableManager/TypeRoom")
    public ModelAndView tableManagerTypeRoom(){
        List<TypeRoom> typeRooms=typeRoomService.findAll();
        ModelAndView modelAndView=new ModelAndView("admin/TableObjectTypeRoom");
        modelAndView.addObject("typeRooms",typeRooms);
        return modelAndView;
    }
    @RequestMapping(value = "/admin/tableManager/RoomName")
    public ModelAndView tableManagerRoomName(){
        List<RoomName> roomNames=roomNameService.findAll();
        List<TypeRoom> typeRooms=typeRoomService.findAll();
        ModelAndView modelAndView=new ModelAndView("admin/TableObjectRoomName");
        modelAndView.addObject("roomNames",roomNames);
        modelAndView.addObject("typeRooms",typeRooms);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/tableManager/TypeRoom/addTypeRoom",method = RequestMethod.POST)
    public String addNewTypeRoom(@RequestParam("TypeName") String TypeName){
        TypeRoom typeRoom=new TypeRoom();
        typeRoom.setType(TypeName);
        if(typeRoomService.save(typeRoom)!=null){
            return "redirect:/admin/tableManager/TypeRoom?saveNew=OK";
        }

        return "redirect:/admin/tableManager/TypeRoom?saveNew=fail";
    }
    @RequestMapping(value = "/admin/tableManager/addNewBed",method = RequestMethod.POST)
    public String addNewBed(@RequestParam("BedName") String bedName){
        Bed bed=new Bed();
        bed.setTypeName(bedName);
        if(bedService.save(bed)){
            return "redirect:/admin/tableManager/Bed?saveNew=OK";
        }

        return "redirect:/admin/tableManager/Bed?saveNew=fail";
    }
    @RequestMapping(value = "/admin/tableManager/RoomName/addRoomName",method = RequestMethod.POST)
    public String addNewRoomName(@RequestParam("RoomName") String roomNameS,@RequestParam("typeRoom") Long TypeRoom){
        RoomName roomName=new RoomName();
        roomName.setName(roomNameS);
        TypeRoom typeRoom= typeRoomService.findByID(TypeRoom);
        roomName.setTypeRoom(typeRoom);
        if(roomNameService.save(roomName)){
            return "redirect:/admin/tableManager/RoomName?saveNew=OK";
        }

        return "redirect:/admin/tableManager/RoomName?saveNew=fail";
    }

    @RequestMapping(value = "/admin/tableManager/deleteBed/{id}")
    public String deleteBed(@PathVariable("id") Long id){

        if(bedService.deletebyID(id)){
            return "redirect:/admin/tableManager/Bed?saveNew=OK";
        }

        return "redirect:/admin/tableManager/Bed?saveNew=fail";
    }
    @RequestMapping(value = "/admin/tableManager/TypeRoom/deleteTypeRoom/{id}")
    public String deleteTypeRoom(@PathVariable("id") Long id){

        if(typeRoomService.deleteById(id)){
            return "redirect:/admin/tableManager/TypeRoom?saveNew=OK";
        }

        return "redirect:/admin/tableManager/TypeRoom?saveNew=fail";
    }

    @RequestMapping(value = "/admin/tableManager/TypeRoom/update/{id}",method = RequestMethod.POST)
    public String updateTypeRoom(@RequestParam("TypeName") String TypeName,@PathVariable("id") Long id){

        if(typeRoomService.update(id,TypeName)){
            return "redirect:/admin/tableManager/TypeRoom?saveNew=OK";
        }

        return "redirect:/admin/tableManager/TypeRoom?saveNew=fail";
    }
    @RequestMapping(value = "/admin/tableManager/update/{id}",method = RequestMethod.POST)
    public String updateBed(@RequestParam("BedName") String bedName,@PathVariable("id") Long id){

        if(bedService.updateBed(id,bedName)){
            return "redirect:/admin/tableManager/Bed?saveNew=OK";
        }

        return "redirect:/admin/tableManager/Bed?saveNew=fail";
    }
    @RequestMapping(value = "/admin/tableManager/RoomName/update/{id}",method = RequestMethod.POST)
    public String updateBed(@RequestParam("typeRoom") Long typeRoom,@PathVariable("id") Long id,@RequestParam("roomNameS") String newName){
        RoomName roomName=roomNameService.findById(id);
        roomName.setName(newName);
        TypeRoom typeRoom1= typeRoomService.findByID(typeRoom);
        roomName.setTypeRoom(typeRoom1);
        if(roomNameService.save(roomName)){
            return "redirect:/admin/tableManager/RoomName?saveNew=OK";
        }

        return "redirect:/admin/tableManager/RoomName?saveNew=fail";
    }
    @RequestMapping(value = "/admin/BanAcc/{id}")
    public String BanAcc(@PathVariable("id")Long id){
        Person person=personService.findById(id);
        if(personService.updateStatus(person,0)){
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }
    @RequestMapping(value = "/admin/UnlockAcc/{id}")
    public String UnlockAcc(@PathVariable("id")Long id){
        Person person=personService.findById(id);
        if(personService.updateStatus(person,1)){
            return "redirect:/admin";
        }
        return "redirect:/admin";
    }



}
