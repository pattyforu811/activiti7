package com.macro.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.entity.UmsAdmin;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台用户表(UmsAdmin)表服务接口层
 *
 * @author patty
 * @since 2020-06-19 14:14:08
 */
public interface UmsAdminService extends IService<UmsAdmin>{
    UserDetails loadUserByUsername(String username);
}