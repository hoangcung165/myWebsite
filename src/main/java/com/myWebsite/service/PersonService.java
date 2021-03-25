package com.myWebsite.service;

import com.myWebsite.entity.Person;

import java.util.List;

public interface PersonService {
    Person findLogin(String user,int status);
    List<Person> findAll();
    boolean register(Person person);
    void save(Person person);
    Person findById(Long id);
}
