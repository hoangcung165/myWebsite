package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Appartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "typeApartment")
    private TypeApartment typeApartment;
    private int amountRoom;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address addressApartment;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Manager owner;
    private String alternativePhone; //số điện thoại thay thế
    private String name;
    @OneToMany(mappedBy = "apartment")
    private List<Room> listRoom;
    @OneToMany(mappedBy = "apartment_img")
    private List<Image> imageList;
    @OneToOne
    @JoinColumn(name = "policy_id")
    private PolicyHotel policyHotel;


    @OneToMany(mappedBy = "apartmentHave")
    private  List<HaveService> haveServiceList;

    public Apartment() {
    }

    public Apartment(Long id, TypeApartment typeApartment, int amountRoom, Address addressApartment, Manager owner, String alternativePhone, String name, List<Room> listRoom, List<Image> imageList, PolicyHotel policyHotel, List<HaveService> haveServiceList) {
        this.id = id;
        this.typeApartment = typeApartment;
        this.amountRoom = amountRoom;
        this.addressApartment = addressApartment;
        this.owner = owner;
        this.alternativePhone = alternativePhone;
        this.name = name;
        this.listRoom = listRoom;
        this.imageList = imageList;
        this.policyHotel = policyHotel;
        this.haveServiceList = haveServiceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeApartment getTypeApartment() {
        return typeApartment;
    }

    public void setTypeApartment(TypeApartment typeApartment) {
        this.typeApartment = typeApartment;
    }

    public int getAmountRoom() {
        return amountRoom;
    }

    public void setAmountRoom(int amountRoom) {
        this.amountRoom = amountRoom;
    }

    public Address getAddressApartment() {
        return addressApartment;
    }

    public void setAddressApartment(Address addressApartment) {
        this.addressApartment = addressApartment;
    }

    public Manager getOwner() {
        return owner;
    }

    public void setOwner(Manager owner) {
        this.owner = owner;
    }

    public String getAlternativePhone() {
        return alternativePhone;
    }

    public void setAlternativePhone(String alternativePhone) {
        this.alternativePhone = alternativePhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public PolicyHotel getPolicyHotel() {
        return policyHotel;
    }

    public void setPolicyHotel(PolicyHotel policyHotel) {
        this.policyHotel = policyHotel;
    }

    public List<HaveService> getHaveServiceList() {
        return haveServiceList;
    }

    public void setHaveServiceList(List<HaveService> haveServiceList) {
        this.haveServiceList = haveServiceList;
    }
}
