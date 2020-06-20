package com.macro.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.entity.UmsAdmin;
import com.macro.mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 后台用户表(UmsAdmin)表服务控制层
 *
 * @author patty
 * @since 2020-06-19 14:40:27
 */
@Api(tags = "后台用户表(UmsAdmin)") 
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("umsAdmin")
public class UmsAdminController extends ApiController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param umsAdmin 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<UmsAdmin> page, UmsAdmin umsAdmin) {
        return success(this.umsAdminService.page(page, new QueryWrapper<>(umsAdmin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.umsAdminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param umsAdmin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody UmsAdmin umsAdmin) {
        return success(this.umsAdminService.save(umsAdmin));
    }

    /**
     * 修改数据
     *
     * @param umsAdmin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody UmsAdmin umsAdmin) {
        return success(this.umsAdminService.updateById(umsAdmin));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.umsAdminService.removeByIds(idList));
    }
}