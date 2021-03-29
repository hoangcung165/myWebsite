package com.myWebsite.service.Interface;

import com.myWebsite.dto.formRegister;
import com.myWebsite.entity.Person;

import java.text.ParseException;

public interface RegisterService {
    boolean register(formRegister register) throws ParseException;
    boolean registerManager(Person person);

}
