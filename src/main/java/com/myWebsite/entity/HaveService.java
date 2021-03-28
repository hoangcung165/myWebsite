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
}
