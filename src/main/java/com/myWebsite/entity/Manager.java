package com.myWebsite.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Person person;

    @OneToMany(mappedBy = "owner")
    private List<Apartment> apartmentList;

    public Manager() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
