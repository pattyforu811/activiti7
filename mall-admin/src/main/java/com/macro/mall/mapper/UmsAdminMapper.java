package com.macro.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.entity.UmsPermission;

import java.util.List;

/**
 * 后台用户表(UmsAdmin)表数据库访问层
 *
 * @author patty
 * @since 2020-06-19 14:14:08
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin>{

    List<UmsPermission> getPermissionList(Long id);
}