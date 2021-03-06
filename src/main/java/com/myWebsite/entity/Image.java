package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentImg;


    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Apartment getApartmentImg() {
        return apartmentImg;
    }

    public void setApartmentImg(Apartment apartmentImg) {
        this.apartmentImg = apartmentImg;
    }
}
