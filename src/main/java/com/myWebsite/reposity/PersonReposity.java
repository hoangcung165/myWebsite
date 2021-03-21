package com.myWebsite.reposity;

import com.myWebsite.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonReposity extends JpaRepository<Person,Long> {
    Person findPersonByUserNameAndStatus(String userName,int status);
}
