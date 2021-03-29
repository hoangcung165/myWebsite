package com.myWebsite.service.Interface;

import com.myWebsite.dto.ChangePassword;
import com.myWebsite.dto.UserUpdateInfor;
import com.myWebsite.entity.Person;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.text.ParseException;
import java.util.List;

public interface PersonService {
    Person findLogin(String user,int status);
    List<Person> findAll();
    boolean register(Person person);
    void save(Person person);
    Person findById(Long id);
    boolean updateAvatar(Long id, CommonsMultipartFile image);
    boolean updateInformattion(UserUpdateInfor userUpdateInfor) throws ParseException;
    boolean changePassword(ChangePassword changePassword);
}
