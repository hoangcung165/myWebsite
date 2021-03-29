package com.myWebsite.service;

import com.myWebsite.entity.Manager;
import com.myWebsite.entity.Person;
import com.myWebsite.reposity.ManagerReposity;
import com.myWebsite.service.Interface.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerReposity reposity;
    @Override
    public void save(Manager manager) {
        reposity.save(manager);
    }

    @Override
    public Manager findByPerson(Person person) {
        return reposity.findByPerson(person);
    }
}
