package com.macro.mall.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户表(UmsAdmin)表实体类
 * 
 * @author patty
 * @since 2020-06-19 14:14:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsAdmin extends Model<UmsAdmin> implements Serializable {
    private static final long serialVersionUID = -61122919768264508L;
            
    @ApiModelProperty("$column.comment")
    private Long id;
            
    @ApiModelProperty("$column.comment")
    private String username;
            
    @ApiModelProperty("$column.comment")
    private String password;
            
    @ApiModelProperty("头像")
    private String icon;
            
    @ApiModelProperty("邮箱")
    private String email;
            
    @ApiModelProperty("昵称")
    private String nickName;
            
    @ApiModelProperty("备注信息")
    private String note;
            
    @ApiModelProperty("创建时间")
    private Date createTime;
            
    @ApiModelProperty("最后登录时间")
    private Date loginTime;
            
    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;


    /**
     * extract primary key value
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }