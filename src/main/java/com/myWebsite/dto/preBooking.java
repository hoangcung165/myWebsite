package com.myWebsite.dto;

import java.util.Date;

public class preBooking {
//    private Long id_user;
    private String id_TinhThanh;
    private String beginDate;
    private String endDate;
    private int qty_customer;
    private int qty_rooms;

    public preBooking() {
    }
//    public preBooking(Long id_user, String id_TinhThanh, String beginDate, String endDate, int qty_customer, int qty_rooms) {
//        this.id_user = id_user;
//        this.id_TinhThanh = id_TinhThanh;
//        this.beginDate = beginDate;
//        this.endDate = endDate;
//        this.qty_customer = qty_customer;
//        this.qty_rooms = qty_rooms;
//    }

    public preBooking(String beginDate, String endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }


    public preBooking(String id_TinhThanh, String beginDate, String endDate, int qty_customer, int qty_rooms) {
        this.id_TinhThanh = id_TinhThanh;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.qty_customer = qty_customer;
        this.qty_rooms = qty_rooms;
    }


    public String getId_TinhThanh() {
        return id_TinhThanh;
    }

    public void setId_TinhThanh(String id_TinhThanh) {
        this.id_TinhThanh = id_TinhThanh;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getQty_customer() {
        return qty_customer;
    }

    public void setQty_customer(int qty_customer) {
        this.qty_customer = qty_customer;
    }

    public int getQty_rooms() {
        return qty_rooms;
    }

    public void setQty_rooms(int qty_rooms) {
        this.qty_rooms = qty_rooms;
    }

    @Override
    public String toString() {
        return "preBooking{" +
                "id_TinhThanh='" + id_TinhThanh + '\'' +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", qty_customer=" + qty_customer +
                ", qty_rooms=" + qty_rooms +
                '}';
    }
}
