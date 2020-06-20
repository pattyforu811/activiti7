package com.macro.mall.entity;

import java.io.Serializable;

/**
 * 后台角色菜单关系表(UmsRoleMenuRelation)实体类
 *
 * @author makejava
 * @since 2020-06-20 19:42:25
 */
public class UmsRoleMenuRelation implements Serializable {
    private static final long serialVersionUID = 803927125040785683L;
    
    private Long id;
    /**
    * 角色ID
    */
    private Long roleId;
    /**
    * 菜单ID
    */
    private Long menuId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}