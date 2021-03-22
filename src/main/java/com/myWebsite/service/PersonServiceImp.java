package com.myWebsite.service;

import com.myWebsite.entity.Person;
import com.myWebsite.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonReposity reposity;
    @Override
    public Person findLogin(String user, int status) {
        return reposity.findPersonByUserNameAndStatus(user,status);
    }

    @Override
    public List<Person> findAll() {
        return reposity.findAll();
    }
}
