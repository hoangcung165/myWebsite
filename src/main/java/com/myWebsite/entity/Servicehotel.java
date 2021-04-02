package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ServiceHotel")
public class Servicehotel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;
    private String icon;

    @OneToMany(mappedBy = "servicehotelHave")
    private List<HaveService> haveService;

    public Servicehotel() {
    }

    public Servicehotel(Long id, String detail, String icon, List<HaveService> haveService) {
        this.id = id;
        this.detail = detail;
        this.icon = icon;
        this.haveService = haveService;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<HaveService> getHaveService() {
        return haveService;
    }

    public void setHaveService(List<HaveService> haveService) {
        this.haveService = haveService;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
