package com.myWebsite.service;

import com.myWebsite.entity.Person;

import java.util.List;

public interface PersonService {
    Person findLogin(String user,int status);
    List<Person> findAll();
}
