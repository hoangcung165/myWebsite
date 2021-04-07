package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Appartment")
public class Apartment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "typeApartment")
    private TypeApartment typeApartment;

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

    @OneToMany(mappedBy = "apartmentImg")
    private List<Image> imgApartment;

    @OneToOne
    private Image logo;

    @OneToOne
    @JoinColumn(name = "policy_id")
    private PolicyHotel policyHotel;


    @OneToMany(mappedBy = "apartmentHave")
    private  List<HaveService> haveServiceList;


    private String shotDescribe;

    @Column(columnDefinition = "TEXT")
    private String detailDescribe;

    public Apartment() {
    }

    public Apartment(Long id, TypeApartment typeApartment, Address addressApartment, Manager owner, String alternativePhone, String name, List<Room> listRoom, List<Image> imgApartment, Image logo, PolicyHotel policyHotel, List<HaveService> haveServiceList, String shotDescribe, String detailDescribe) {
        this.id = id;
        this.typeApartment = typeApartment;
        this.addressApartment = addressApartment;
        this.owner = owner;
        this.alternativePhone = alternativePhone;
        this.name = name;
        this.listRoom = listRoom;
        this.imgApartment = imgApartment;
        this.logo = logo;
        this.policyHotel = policyHotel;
        this.haveServiceList = haveServiceList;
        this.shotDescribe = shotDescribe;
        this.detailDescribe = detailDescribe;
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

    public List<Image> getImgApartment() {
        return imgApartment;
    }

    public void setImgApartment(List<Image> imgApartment) {
        this.imgApartment = imgApartment;
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

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getShotDescribe() {
        return shotDescribe;
    }

    public void setShotDescribe(String shotDescribe) {
        this.shotDescribe = shotDescribe;
    }

    public String getDetailDescribe() {
        return detailDescribe;
    }

    public void setDetailDescribe(String detailDescribe) {
        this.detailDescribe = detailDescribe;
    }
}
