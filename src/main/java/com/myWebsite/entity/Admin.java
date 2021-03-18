package com.myWebsite.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin extends User{

    public Admin() {
        super();

    }

}
