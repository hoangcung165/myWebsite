package com.myWebsite.reposity;

import com.myWebsite.entity.Apartment;
import com.myWebsite.entity.Manager;
import com.myWebsite.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerReposity extends JpaRepository<Manager,Long> {
    Manager findByPerson(Person person);
    
}
