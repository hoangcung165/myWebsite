package com.myWebsite.controller.web;

import com.myWebsite.dto.*;
import com.myWebsite.entity.*;
import com.myWebsite.service.Interface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class Ajax {
    @Autowired
    private TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private XaService xaService;

    @Autowired
    private RoomNameService roomNameService;

    @Autowired
    private TypeRoomService typeRoomService;

    @Autowired
    private RoomService roomService;


    @GetMapping("/findHuyen")
    public List<QuanHuyenDTO> listString(HttpServletRequest request){
        String tinh_id=request.getParameter("tinh_id");
        List<devvn_quanhuyen> quanhuyenList=huyenService.findByMatp(tinh_id);
        List<QuanHuyenDTO> out=new ArrayList<>();
        for (devvn_quanhuyen quanhuyen:quanhuyenList){
            QuanHuyenDTO quanHuyenDTO=new QuanHuyenDTO();
            quanHuyenDTO.setId(quanhuyen.getMaqh());
            quanHuyenDTO.setName(quanhuyen.getName());
            out.add(quanHuyenDTO);
        }

        for(QuanHuyenDTO quanHuyenDTO:out){
            System.out.println(quanHuyenDTO.getName());
        }

       return out;
    }
    @GetMapping("/findXa")
    public List<XaDTO> listXa(HttpServletRequest request){

        String huyen_id=request.getParameter("huyen_id");
        System.out.println(huyen_id);
        List<devvn_xaphuongthitran> xaphuongthitranList=xaService.findByhuyen(huyen_id);
        List<XaDTO> out=new ArrayList<>();
        for (devvn_xaphuongthitran xaphuongthitran:xaphuongthitranList){
            XaDTO xaDTO=new XaDTO();
            xaDTO.setId(xaphuongthitran.getXaid());
            xaDTO.setName(xaphuongthitran.getName());
            out.add(xaDTO);
        }
        for(XaDTO xaDTO:out){
            System.out.println(xaDTO.getName());
        }


        return out;
    }
    @GetMapping("/findRoomName")
    public List<RoomNameDTO> findRoomName(HttpServletRequest request){
        String typeRoomString=request.getParameter("typeRoomId");
        Long typeRoomID=Long.parseLong(typeRoomString);
        TypeRoom typeRoom= typeRoomService.findByID(typeRoomID);

        List<RoomNameDTO> roomNamesDTO=new ArrayList<>();
        System.out.println(typeRoomString);
        List<RoomName>roomNames=roomNameService.findByTypeRoom(typeRoom);
        System.out.println(roomNames.size());
        for(RoomName roomName:roomNames){
            RoomNameDTO roomNameDTO=new RoomNameDTO();
            roomNameDTO.setId(roomName.getId());
            roomNameDTO.setName(roomName.getName());
            roomNamesDTO.add(roomNameDTO);
        }
        for(RoomNameDTO roomNameDTO:roomNamesDTO){
            System.out.println(roomNameDTO.getName());
        }
        return  roomNamesDTO;
    }
    @GetMapping(value = "/checkAvailable")
    public cofigBooking checkAvailable(@ModelAttribute("preBooking") preBooking booking, HttpServletRequest request){
        cofigBooking out=new cofigBooking();
        System.out.println(booking.getBeginDate());

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1=dateFormat.parse(booking.getBeginDate());
            Date date2=dateFormat.parse(booking.getEndDate());
            long diff=date2.getTime()-date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            int dates=(int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            out.setDates(dates);
            out.setQtyRoomMax(booking.getQty_customer());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(booking);
        System.out.println(out);
        HttpSession session=request.getSession();
        session.setAttribute("booking",booking);
        return out;
    }
//    @GetMapping(value = "/calBill/{id_room}")
//    public CalBillDTO calBill(HttpServletRequest request, @PathVariable("id_room") String id){
//        Room room=roomService.findById((Long) Long.parseLong(id));
//        int price=room.getPrice();
//        String typeRoomString=request.getParameter("typeRoomId");
//
//    }
//    @GetMapping(value = "/booking/checkBill")
//    public  checkBill(){}
}
