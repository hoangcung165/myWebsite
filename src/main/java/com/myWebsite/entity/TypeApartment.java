package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TypeApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    @OneToMany(mappedBy = "typeApartment")
    private List<Apartment> listApartment;
    public TypeApartment() {
    }

    public TypeApartment(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
