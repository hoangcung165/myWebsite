package com.myWebsite.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Person customer;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    private Date begin;
    private Date finish;

    private int pay;
    private int qty_customer;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private int status;
    private int qty_room;

    public Booking() {
    }

    public Booking(Long id, Person customer, Apartment apartment, Date begin, Date finish, int pay, int qty_customer, Room room, int status, int qty_room) {
        this.id = id;
        this.customer = customer;
        this.apartment = apartment;
        this.begin = begin;
        this.finish = finish;
        this.pay = pay;
        this.qty_customer = qty_customer;
        this.room = room;
        this.status = status;
        this.qty_room = qty_room;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getQty_customer() {
        return qty_customer;
    }

    public void setQty_customer(int qty_customer) {
        this.qty_customer = qty_customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQty_room() {
        return qty_room;
    }

    public void setQty_room(int qty_room) {
        this.qty_room = qty_room;
    }
}
