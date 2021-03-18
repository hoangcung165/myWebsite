package com.myWebsite.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createddate")
    private Date createddate;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "modifiedby")
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
