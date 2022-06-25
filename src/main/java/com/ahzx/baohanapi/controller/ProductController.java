package com.ahzx.baohanapi.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 *  1同步产品接口
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Api(tags="同步产品接口")
@Slf4j
@RestController
@RequestMapping("/baohanapi/product")
public class ProductController {

    /**
     * 1
     *  省综合金融服务平台上架金融机构产品信息时，省综合服务平台请求中鑫中科接口同步金融产品数据信息
     *  中鑫中科上架产品信息时，中鑫中科请求省综合金融服务平台接口同步金融机构产品数据信息
     */
}

