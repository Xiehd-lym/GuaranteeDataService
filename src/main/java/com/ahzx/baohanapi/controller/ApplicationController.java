package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.service.ApplicationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 投保申请表 前端控制器
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Api(tags="同步数据模块")
@RestController
@RequestMapping("/baohanapi/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * 简单查询
     * @param id
     * @return
     */
    @ApiOperation(value="简单查询",notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "产品id", dataType = "String")
    })
    @PostMapping("getById")
    public Application getApplicationById(@RequestParam String id){
        return applicationService.getById(id);
    }

    /**
     * 查询所有 不分页
     * @return
     */
    @ApiOperation(value="查询所有",notes="")
    @PostMapping("list")
    public R listApplication(){
        List<Application> list = applicationService.list();
        return R.ok().data("pageModel",list);
    }

    /**
     * 新增
     * @return
     */
    @ApiOperation(value="新增",notes="")
    @PostMapping("save")
    public R listApplication(@RequestBody Application application){
        boolean save = applicationService.save(application);
        return R.ok().data("save",save);
    }

    /**
     * 分页查询
     */
    @PostMapping(value = "pageList")
    @ApiOperation(value = "分页查询")
    public R pageList(@RequestParam Long page ,@RequestParam Long limit){
        Page<Application> pageParam = new Page<>(page, limit);
        Page<Application> page1 = applicationService.page(pageParam);
        return R.ok().data("pageList",page1);

    }
}

