package com.myWebsite.dto;

import javax.xml.crypto.Data;
import java.util.Date;

public class formRegister {
    private String fullName;
    private String birthday;
    private String gender;
    private String email;
    private String userName;
    private String password;
    private String national;
    private String idCity;
    private String idDistrict;
    private String idWard;
    private String houseNumber;
    private String phone;

    public formRegister() {
    }

    public formRegister(String fullName, String birthday, String gender, String email, String userName, String password, String national, String idCity, String idDistrict, String idWard, String houseNumber, String phone) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.national = national;
        this.idCity = idCity;
        this.idDistrict = idDistrict;
        this.idWard = idWard;
        this.houseNumber = houseNumber;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
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

    @Override
    public String toString() {
        return "formRegister{" +
                "fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", national='" + national + '\'' +
                ", idCity='" + idCity + '\'' +
                ", idDistrict='" + idDistrict + '\'' +
                ", idWard='" + idWard + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
