package com.myWebsite.dto;

import java.util.Date;

public class UserUpdateInfor {
    private String fullname;
    private String birthday;
    private String gender;
    private String email;
    private String nationality;
    private String idCity;
    private String idDistrict;
    private String idWard;
    private String houseNumber;
    private String phone;
    private Long user_id;
    private Long address_id;

    public UserUpdateInfor() {
    }

    public UserUpdateInfor(String fullname, String birthday, String gender, String email, String nationality, String idCity, String idDistrict, String idWard, String houseNumber, String phone, Long user_id, Long address_id) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.nationality = nationality;
        this.idCity = idCity;
        this.idDistrict = idDistrict;
        this.idWard = idWard;
        this.houseNumber = houseNumber;
        this.phone = phone;
        this.user_id = user_id;
        this.address_id = address_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}

