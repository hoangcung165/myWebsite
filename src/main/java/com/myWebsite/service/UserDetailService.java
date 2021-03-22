package com.myWebsite.service;

import com.myWebsite.dto.MyUser;
import com.myWebsite.entity.Person;
import com.myWebsite.entity.Role;
import com.myWebsite.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PersonReposity personReposity;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person myPerson=personReposity.findPersonByUserNameAndStatus(userName,1);
        if(myPerson!=null){
            System.out.println("name: "+myPerson.getUserName()+" status:"+myPerson.getStatus());
        }
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for (Role role:myPerson.getRoleList()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        MyUser myUser=new MyUser(myPerson.getUserName(), myPerson.getPassword(),
                true, true, true, true,grantedAuthorities );;
        myUser.setFullName(myPerson.getName());
        return myUser;
    }
}
