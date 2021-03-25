package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devvn_quanhuyen")
public class devvn_quanhuyen {
    @Id @Column(insertable = false,updatable = false)
    private String maqh;
    @Column(insertable = false,updatable = false)
    private String name;
    @Column(insertable = false,updatable = false)
    private String type;
    @Column(insertable = false,updatable = false)
    private String matp;
    @ManyToOne
    private devvn_tinhthanhpho tinhthanhpho;

    @OneToMany(mappedBy = "quanhuyen")
    private List<devvn_xaphuongthitran> xaphuongthitranList;

    @OneToMany(mappedBy = "quanhuyenAddress")
    private List<Address> listAddress;

    public devvn_quanhuyen() {
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
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

    public devvn_tinhthanhpho getTinhthanhpho() {
        return tinhthanhpho;
    }

    public void setTinhthanhpho(devvn_tinhthanhpho tinhthanhpho) {
        this.tinhthanhpho = tinhthanhpho;
    }

    public List<devvn_xaphuongthitran> getXaphuongthitranList() {
        return xaphuongthitranList;
    }

    public void setXaphuongthitranList(List<devvn_xaphuongthitran> xaphuongthitranList) {
        this.xaphuongthitranList = xaphuongthitranList;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    @Override
    public String toString() {
        return "devvn_quanhuyen{" +
                "maqh='" + maqh + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tinhthanhpho=" + tinhthanhpho +
                ", xaphuongthitranList=" + xaphuongthitranList +
                ", listAddress=" + listAddress +
                '}';
    }
}
