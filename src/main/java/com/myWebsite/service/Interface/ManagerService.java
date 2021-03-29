package com.myWebsite.service.Interface;

import com.myWebsite.entity.Manager;
import com.myWebsite.entity.Person;

public interface ManagerService {
    void save(Manager manager);
    Manager findByPerson(Person person);
}
