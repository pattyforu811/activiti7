package com.macro.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.service.UmsAdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 后台用户表(UmsAdmin)表服务实现类
 *
 * @author patty
 * @since 2020-06-19 14:14:09
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Resource
    private UmsAdminMapper mapper;


    @Override
    public UserDetails loadUserByUsername(String username) {





        return null;
    }
}