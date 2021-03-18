package com.myWebsite.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public Category() {
    }

    public Category( String name, String code) {

        this.name = name;
        this.code = code;
    }



    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
