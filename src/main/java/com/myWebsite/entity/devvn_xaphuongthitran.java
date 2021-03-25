package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devvn_xaphuongthitran")
    public class devvn_xaphuongthitran {
    @Id
    @Column(insertable = false,updatable = false)
    private String xaid;
    @Column(insertable = false,updatable = false)
    private String name;
    @Column(insertable = false,updatable = false)
    private String type;
    @Column(insertable = false,updatable = false)
    private String maqh;
    @ManyToOne
    private devvn_quanhuyen quanhuyen;

    @OneToMany(mappedBy = "xaphuongthitranAddress")
    private List<Address> listAddress;

    public devvn_xaphuongthitran() {
    }

    public String getXaid() {
        return xaid;
    }

    public void setXaid(String xaid) {
        this.xaid = xaid;
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

    public devvn_quanhuyen getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(devvn_quanhuyen quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

    public List<Address> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<Address> listAddress) {
        this.listAddress = listAddress;
    }

    @Override
    public String toString() {
        return "devvn_xaphuongthitran{" +
                "xaid='" + xaid + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quanhuyen=" + quanhuyen +
                ", listAddress=" + listAddress +
                '}';
    }
}
