package com.macro.mall.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 后台菜单表(UmsMenu)表实体类
 * 
 * @author patty
 * @since 2020-06-23 14:33:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "")
@SuppressWarnings("serial")
public class UmsMenu extends Model<UmsMenu> implements Serializable {
    private static final long serialVersionUID = -75623674007240599L;
            
    @ApiModelProperty("$column.comment")
    private Long id;
            
    @ApiModelProperty("父级ID")
    private Long parentId;
            
    @ApiModelProperty("创建时间")
    private Date createTime;
            
    @ApiModelProperty("菜单名称")
    private String title;
            
    @ApiModelProperty("菜单级数")
    private Integer level;
            
    @ApiModelProperty("菜单排序")
    private Integer sort;
            
    @ApiModelProperty("前端名称")
    private String name;
            
    @ApiModelProperty("前端图标")
    private String icon;
            
    @ApiModelProperty("前端隐藏")
    private Integer hidden;


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