package com.myWebsite.dto;

import com.myWebsite.entity.Address;
import com.myWebsite.entity.devvn_quanhuyen;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class TinhDTO {
    private String matp;

    private String name;

    private String type;


    private List<devvn_quanhuyen> quanhuyenList;

    private List<Address> listAddress;

    public TinhDTO() {

    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<devvn_quanhuyen> getQuanhuyenList() {
        return quanhuyenList;
    }

    public void setQuanhuyenList(List<devvn_quanhuyen> quanhuyenList) {
        this.quanhuyenList = quanhuyenList;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }
}
