package com.myWebsite.controller.web;

import com.myWebsite.dto.QuanHuyenDTO;
import com.myWebsite.dto.TinhDTO;
import com.myWebsite.dto.XaDTO;
import com.myWebsite.entity.devvn_quanhuyen;
import com.myWebsite.entity.devvn_tinhthanhpho;
import com.myWebsite.entity.devvn_xaphuongthitran;
import com.myWebsite.service.HuyenService;
import com.myWebsite.service.TinhService;
import com.myWebsite.service.XaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Ajax {
    @Autowired
    private TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private XaService xaService;



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
}
