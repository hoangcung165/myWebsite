package com.myWebsite.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

public class HotelRegister {
    private String typeApartment; //id_typeApartment
    private String name;//hotel_name
    private String id_user;//user
    private String idCity;//address
    private String idDistrict;//address
    private String idWard;//address
    private String houseNumber;//address
    private String typeRoom; //id_typeRoom
    private String roomName;//roomname
    private String smokking;
    private String kindOfBed;
    private int qtyBeds;
    private int qty_customer;
    private int qty_room;
    private int size;
    private int price;
    private List<String> listService;
    private List<CommonsMultipartFile> listImages;
    private CommonsMultipartFile logo;
    private String shortDes;
    private String detail;

    public HotelRegister() {
    }

    public HotelRegister(String typeApartment, String name, String id_user, String idCity, String idDistrict, String idWard, String houseNumber, String typeRoom, String roomName, String smokking, String kindOfBed, int qtyBeds, int qty_customer, int qty_room, int size, int price, List<String> listService, List<CommonsMultipartFile> listImages, CommonsMultipartFile logo, String shortDes, String detail) {
        this.typeApartment = typeApartment;
        this.name = name;
        this.id_user = id_user;
        this.idCity = idCity;
        this.idDistrict = idDistrict;
        this.idWard = idWard;
        this.houseNumber = houseNumber;
        this.typeRoom = typeRoom;
        this.roomName = roomName;
        this.smokking = smokking;
        this.kindOfBed = kindOfBed;
        this.qtyBeds = qtyBeds;
        this.qty_customer = qty_customer;
        this.qty_room = qty_room;
        this.size = size;
        this.price = price;
        this.listService = listService;
        this.listImages = listImages;
        this.logo = logo;
        this.shortDes = shortDes;
        this.detail = detail;
    }

    public String getTypeApartment() {
        return typeApartment;
    }

    public void setTypeApartment(String typeApartment) {
        this.typeApartment = typeApartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getIdWard() {
        return idWard;
    }

    public void setIdWard(String idWard) {
        this.idWard = idWard;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSmokking() {
        return smokking;
    }

    public void setSmokking(String smokking) {
        this.smokking = smokking;
    }

    public String getKindOfBed() {
        return kindOfBed;
    }

    public void setKindOfBed(String kindOfBed) {
        this.kindOfBed = kindOfBed;
    }

    public int getQtyBeds() {
        return qtyBeds;
    }

    public void setQtyBeds(int qtyBeds) {
        this.qtyBeds = qtyBeds;
    }

    public int getQty_customer() {
        return qty_customer;
    }

    public void setQty_customer(int qty_customer) {
        this.qty_customer = qty_customer;
    }

    public int getQty_room() {
        return qty_room;
    }

    public void setQty_room(int qty_room) {
        this.qty_room = qty_room;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getListService() {
        return listService;
    }

    public void setListService(List<String> listService) {
        this.listService = listService;
    }

    public List<CommonsMultipartFile> getListImages() {
        return listImages;
    }

    public void setListImages(List<CommonsMultipartFile> listImages) {
        this.listImages = listImages;
    }

    public CommonsMultipartFile getLogo() {
        return logo;
    }

    public void setLogo(CommonsMultipartFile logo) {
        this.logo = logo;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "HotelRegister{" +
                "typeApartment='" + typeApartment + '\'' +
                ", name='" + name + '\'' +
                ", id_user='" + id_user + '\'' +
                ", idCity='" + idCity + '\'' +
                ", idDistrict='" + idDistrict + '\'' +
                ", idWard='" + idWard + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                ", roomName='" + roomName + '\'' +
                ", smokking='" + smokking + '\'' +
                ", kindOfBed='" + kindOfBed + '\'' +
                ", qtyBeds=" + qtyBeds +
                ", qty_customer=" + qty_customer +
                ", qty_room=" + qty_room +
                ", size=" + size +
                ", price=" + price +
                ", listService=" + listService +

                '}';
    }
}
