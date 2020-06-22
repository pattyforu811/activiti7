package com.macro.mall.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台用户权限表(UmsPermission)表实体类
 * 
 * @author patty
 * @since 2020-06-22 10:18:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsPermission extends Model<UmsPermission> implements Serializable {
    private static final long serialVersionUID = 483534849881164844L;
            
    @ApiModelProperty("$column.comment")
    private Long id;
            
    @ApiModelProperty("父级权限id")
    private Long pid;
            
    @ApiModelProperty("名称")
    private String name;
            
    @ApiModelProperty("权限值")
    private String value;
            
    @ApiModelProperty("图标")
    private String icon;
            
    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;
            
    @ApiModelProperty("前端资源路径")
    private String uri;
            
    @ApiModelProperty("启用状态；0->禁用；1->启用")
    private Integer status;
            
    @ApiModelProperty("创建时间")
    private Date createTime;
            
    @ApiModelProperty("排序")
    private Integer sort;


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