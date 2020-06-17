package com.macro.mall.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AdminService {
    UserDetails loadUserByUsername(String username);
}
