package com.myWebsite.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createddate")
    @CreatedDate
    private Date createddate;


    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifieddate;

    @Column(name = "createdby")
    @CreatedBy
    private String createdby;


    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedby;

    public Long getId() {
        return id;
    }

    public Date getCreateddate() {
        return createddate;
    }



    public Date getModifieddate() {
        return modifieddate;
    }



    public String getCreatedby() {
        return createdby;
    }


    public String getModifiedby() {
        return modifiedby;
    }


}
