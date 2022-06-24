package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 投保申请表 前端控制器
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("/baohanapi/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("getById")
    public Application getApplicationById(@RequestParam String id){
        return applicationService.getById(id);
    }

}

