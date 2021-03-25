package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devvn_tinhthanhpho")
public class devvn_tinhthanhpho {
    @Id @Column(insertable = false,updatable = false)
    private String matp;
    @Column(insertable = false,updatable = false)
    private String name;
    @Column(insertable = false,updatable = false)
    private String type;

    @OneToMany(mappedBy = "tinhthanhpho")
    private List<devvn_quanhuyen> quanhuyenList;

    @OneToMany(mappedBy = "tinhthanhphoAddress")
    private List<Address> listAddress;

    public devvn_tinhthanhpho() {
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

    @Override
    public String toString() {
        return "devvn_tinhthanhpho{" +
                "matp='" + matp + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quanhuyenList=" + quanhuyenList +
                ", listAddress=" + listAddress +
                '}';
    }
}
