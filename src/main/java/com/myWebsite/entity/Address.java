package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "houseNum")
    private String houseNum;

    @ManyToOne
    @JoinColumn(name = "xa_id")
    private devvn_xaphuongthitran xaphuongthitranAddress;
    @ManyToOne
    @JoinColumn(name = "huyen_id")
    private devvn_quanhuyen quanhuyenAddress;
    @ManyToOne
    @JoinColumn(name = "tinh_id")
    private devvn_tinhthanhpho tinhthanhphoAddress;

    @OneToOne(mappedBy = "address")
    private Person person;

    @OneToOne(mappedBy = "addressApartment")
    private Apartment apartment;



    public Address() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public devvn_xaphuongthitran getXaphuongthitranAddress() {
        return xaphuongthitranAddress;
    }

    public void setXaphuongthitranAddress(devvn_xaphuongthitran xaphuongthitranAddress) {
        this.xaphuongthitranAddress = xaphuongthitranAddress;
    }

    public devvn_quanhuyen getQuanhuyenAddress() {
        return quanhuyenAddress;
    }

    public void setQuanhuyenAddress(devvn_quanhuyen quanhuyenAddress) {
        this.quanhuyenAddress = quanhuyenAddress;
    }

    public devvn_tinhthanhpho getTinhthanhphoAddress() {
        return tinhthanhphoAddress;
    }

    public void setTinhthanhphoAddress(devvn_tinhthanhpho tinhthanhphoAddress) {
        this.tinhthanhphoAddress = tinhthanhphoAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return houseNum +
                ", " + xaphuongthitranAddress.getName() +
                ", " + quanhuyenAddress.getName() +
                ", " + tinhthanhphoAddress.getName() ;
    }

}
