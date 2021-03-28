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

    @OneToMany(mappedBy = "servicehotelHave")
    private List<HaveService> haveService;

    public Servicehotel() {
    }

    public Servicehotel(Long id, String detail) {
        this.id = id;
        this.detail = detail;
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
}
