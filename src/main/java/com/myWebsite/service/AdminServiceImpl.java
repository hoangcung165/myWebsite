package com.myWebsite.service;


import com.myWebsite.entity.Admin;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl {
    Admin admin=new Admin();


}
