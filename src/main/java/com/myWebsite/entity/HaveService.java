package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table
public class HaveService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentHave;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Servicehotel servicehotelHave;

    public HaveService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartmentHave() {
        return apartmentHave;
    }

    public void setApartmentHave(Apartment apartmentHave) {
        this.apartmentHave = apartmentHave;
    }

    public Servicehotel getServicehotelHave() {
        return servicehotelHave;
    }

    public void setServicehotelHave(Servicehotel servicehotelHave) {
        this.servicehotelHave = servicehotelHave;
    }
}
