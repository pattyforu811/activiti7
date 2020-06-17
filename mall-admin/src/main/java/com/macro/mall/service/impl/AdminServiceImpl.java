package com.macro.mall.service.impl;

import com.macro.mall.dao.AdminDao;
import com.macro.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;


    @Override
    public UserDetails loadUserByUsername(String username) {




        return null;
    }
}
