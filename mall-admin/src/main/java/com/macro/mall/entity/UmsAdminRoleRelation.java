package com.macro.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-06-20 19:42:24
 */
@Data
public class UmsAdminRoleRelation extends Model<UmsAdminRoleRelation> implements Serializable {
    private static final long serialVersionUID = 295365671663825447L;

    private Long id;
    
    private Long adminId;
    
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}