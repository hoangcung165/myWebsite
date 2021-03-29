package com.myWebsite.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room extends BaseEntity{


    @Column(name = "smoking")
    private String smoking;

    private int amout_bed;
    @Column(name = "quantityCustomer")
    private int quantityCustomer;
    @Column(name = "size")
    private int size;
    @Column(name = "price")
    private int price;
//    private String codeSale;

//    @OneToMany(mappedBy = "roomBed")
//    private List<Bed> bedList=new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "typeRoom_id",referencedColumnName = "id")
    private TypeRoom typeRoom;

    @OneToOne
    @JoinColumn(name = "roomName_id",referencedColumnName = "id")
    private RoomName roomName;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    private String status;
    public Room() {
    }
    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public RoomName getRoomName() {
        return roomName;
    }

    public void setRoomName(RoomName roomName) {
        this.roomName = roomName;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public int getAmout_bed() {
        return amout_bed;
    }

    public void setAmout_bed(int amout_bed) {
        this.amout_bed = amout_bed;
    }

    public int getQuantityCustomer() {
        return quantityCustomer;
    }

    public void setQuantityCustomer(int quantityCustomer) {
        this.quantityCustomer = quantityCustomer;
    }

//    public List<Bed> getBedList() {
//        return bedList;
//    }
//
//    public void setBedList(List<Bed> bedList) {
//        this.bedList = bedList;
//    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
