package com.macro.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.bo.UserDetailsImpl;
import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.entity.UmsAdminRoleRelation;
import com.macro.mall.entity.UmsPermission;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.service.UmsAdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
        UmsAdmin umsAdmin = getAdminByUsername(username);

        if (umsAdmin != null) {
            List<UmsPermission> list = getPermissionList(umsAdmin.getId());
            new UserDetailsImpl(umsAdmin, list);
        }


        return null;
    }

    private List<UmsPermission> getPermissionList(Long id) {
         return mapper.getPermissionList(id);
    }

    private UmsAdmin getAdminByUsername(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        List<UmsAdmin> list = mapper.selectList(queryWrapper);
        if (list.size() > 0) {
            return list.get(0);
        }

        return null;

    }
}