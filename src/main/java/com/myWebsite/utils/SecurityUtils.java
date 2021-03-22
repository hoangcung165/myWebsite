package com.myWebsite.utils;

import com.myWebsite.dto.MyUser;
import com.myWebsite.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {
    public SecurityUtils() {
    }

    public static MyUser getPrincial(){
        MyUser myUser=(MyUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return myUser;
    }

    @SuppressWarnings("uncheck")
    public static List<String> getAuthorites(){
        List<String> roleString=new ArrayList<>();
        List<GrantedAuthority> authorities=(List<GrantedAuthority>) (SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for(GrantedAuthority authority:authorities){
            roleString.add(authority.getAuthority());
        }
        return roleString;
    }
}
