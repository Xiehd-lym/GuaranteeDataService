package com.ahzx.baohanapi.controller;

import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.entity.query.ApplicationQuery;
import com.ahzx.baohanapi.service.ApplicationService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("save结果:{}",save);
        return R.ok();
    }

    /**
     * 分页查询
     */
    @GetMapping(value = "pageList")
    @ApiOperation(value = "分页查询")
    public R pageList(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit){
        Page<Application> pageParam = new Page<>(page, limit);
        Page<Application> pageList = applicationService.page(pageParam);
        return R.ok().data("pageList",pageList);
    }

    /**
     * 分页条件查询投保信息
     * @param page
     * @param limit
     * @param applicationQuery
     * @return
     */
    @ApiOperation("分页投保申请")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象") ApplicationQuery applicationQuery){

        IPage<Application> pageModel = applicationService.selectPage(page, limit, applicationQuery);
        return  R.ok().data("pageModel", pageModel);
    }

    @ApiOperation("测试")
    @GetMapping("/index")
    public String index(){
        return  "hello!";
    }

}

