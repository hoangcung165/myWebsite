package com.myWebsite.service;

import com.myWebsite.entity.Person;
import com.myWebsite.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonReposity reposity;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Person findLogin(String user, int status) {
        return reposity.findPersonByUserNameAndStatus(user,status);
    }

    @Override
    public List<Person> findAll() {
        return reposity.findAll();
    }

    @Override
    public boolean register(Person person) {
        if(checkExist(person.getMail())){

            return false;
        }
        try{
            passwordEncoder(person);
            reposity.save(person);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public void save(Person person) {
        reposity.save(person);
    }

    @Override
    public Person findById(Long id) {
        return reposity.findById(id).get();
    }

    private boolean checkExist(String email){
        Person person=reposity.findPersonByMail(email);
        if(person!=null){
            return true;
        }
        return false;
    }
    private void passwordEncoder(Person person){
        String password=person.getPassword();
        person.setPassword(bCryptPasswordEncoder.encode(password));
    }

}
