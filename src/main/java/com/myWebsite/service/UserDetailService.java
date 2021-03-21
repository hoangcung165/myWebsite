package com.myWebsite.service;

import com.myWebsite.dto.MyUser;
import com.myWebsite.entity.Person;
import com.myWebsite.reposity.PersonReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private PersonReposity personReposity;
    public UserDetailService(){
        super();
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        MyUser myUser=new MyUser("admin165", "$2a$10$DPzHnInANVY1utbuRfe0eOojtE02k23TGB5Q0L6mIHOBJQhKU7DTi",
                true, true, true, true,grantedAuthorities );;

        return myUser;
    }
}
