package com.macro.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.entity.UmsAdmin;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台用户表(UmsAdmin)表服务接口层
 *
 * @author patty
 * @since 2020-06-19 14:14:08
 */
public interface UmsAdminService extends IService<UmsAdmin>{
    /**
     *获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 用户注册
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    String login(String username, String password);
}