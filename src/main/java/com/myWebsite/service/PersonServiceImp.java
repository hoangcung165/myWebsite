package com.myWebsite.service;

import com.myWebsite.dto.ChangePassword;
import com.myWebsite.dto.UserUpdateInfor;
import com.myWebsite.entity.*;
import com.myWebsite.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonReposity reposity;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ImageService imageService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private  TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private XaService xaService;

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

    @Override
    public boolean updateAvatar(Long id, CommonsMultipartFile image) {
        try{

            Image avatar=imageService.uploadImage(image);
            if(avatar!=null){
                Person person=findById(id);
                person.setImage(avatar);
                save(person);
                return true;
            }
            return false;

        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateInformattion(UserUpdateInfor userUpdateInfor) throws ParseException {
        Person person=findById(userUpdateInfor.getUser_id());
        Address address=addressService.findbyId(userUpdateInfor.getAddress_id());

        if(person!=null && address!=null){
            person.setName(userUpdateInfor.getFullname());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date birthday=simpleDateFormat.parse(userUpdateInfor.getBirthday().toString());
            person.setBirtday(birthday);
            person.setMail(userUpdateInfor.getEmail());
            person.setNationality(userUpdateInfor.getNationality());

            address.setHouseNum(userUpdateInfor.getHouseNumber());
            devvn_xaphuongthitran xa=xaService.findById(userUpdateInfor.getIdWard());
            address.setXaphuongthitranAddress(xa);
            devvn_quanhuyen quanhuyen=huyenService.findById(userUpdateInfor.getIdDistrict());
            address.setQuanhuyenAddress(quanhuyen);
            devvn_tinhthanhpho tinhthanhpho= tinhService.findById(userUpdateInfor.getIdCity());
            address.setTinhthanhphoAddress(tinhthanhpho);

            addressService.save(address);

            person.setAddress(address);

            save(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(ChangePassword changePassword) {
        System.out.println("old pass: "+changePassword.getOld_pass()+"\nNew Pass: "+changePassword.getNew_pass() );
        Person person=this.findById(changePassword.getUser_id());
        if(checkPassword(changePassword.getOld_pass(),person)){

            person.setPassword(changePassword.getNew_pass());
            passwordEncoder(person);
            save(person);
            return true;
        }
        return false;
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
    private boolean checkPassword(String old_password,Person person){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if(encoder.matches(old_password,person.getPassword())){
            System.out.println("checkPassword:true");
            return true;
        }
        return false;
    }

}
