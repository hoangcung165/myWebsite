package com.myWebsite.service;

import com.myWebsite.constant.SystemConstant;
import com.myWebsite.dto.MyUser;
import com.myWebsite.dto.formRegister;
import com.myWebsite.entity.*;
import com.myWebsite.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private  TinhService tinhService;

    @Autowired
    private HuyenService huyenService;

    @Autowired
    private XaService xaService;

    @Autowired
    PersonService personService;

    @Autowired
    RoleService roleService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ManagerService managerService;

    @Override
    public boolean register(formRegister register) throws ParseException {
        Person person=new Person();
        System.out.println(register);
        person.setName(register.getFullName());
        person.setMail(register.getEmail());
        person.setPassword(register.getPassword());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthday=simpleDateFormat.parse(register.getBirthday().toString());
        person.setBirtday(birthday);
        person.setNationality(register.getNational());
        person.setPhone(register.getPhone());
        person.setGender(register.getGender());
        person.setUserName(register.getUserName());
        person.setStatus(1);

        setRolesForPerson(person,SystemConstant.USER_ROLE);
        Address address=new Address();

        address.setHouseNum(register.getHouseNumber());
        devvn_xaphuongthitran xa=xaService.findById(register.getIdWard());
        address.setXaphuongthitranAddress(xa);
        devvn_quanhuyen quanhuyen=huyenService.findById(register.getIdDistrict());
        address.setQuanhuyenAddress(quanhuyen);
        devvn_tinhthanhpho tinhthanhpho= tinhService.findById(register.getIdCity());
        address.setTinhthanhphoAddress(tinhthanhpho);

        addressService.save(address);

        System.out.println(address.getHouseNum()+"  "+address.getTinhthanhphoAddress().getName());

        person.setAddress(address);

        try {
            personService.register(person);
            return true;
        }
        catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean registerManager(Person person) {
        try {
            setRolesForPerson(person,SystemConstant.MANAGER_ROLE);
            personService.save(person);
            Manager manager=new Manager();
            manager.setPerson(person);
            managerService.save(manager);

            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    private void setRolesForPerson(Person person,String role_code){
        List<Role> roleList=person.getRoleList();
        Role role=roleService.findByCode(role_code);
        roleList.add(role);
        person.setRoleList(roleList);

    }
}
