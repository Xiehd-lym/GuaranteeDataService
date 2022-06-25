package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.entity.Guarantee;
import com.ahzx.baohanapi.service.GuaranteeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 保函表 前端控制器
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("/baohanapi/guarantee")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    /**
     * 新增
     * @return
     */
    @ApiOperation(value="新增",notes="")
    @PostMapping("save")
    public R save(@RequestBody Guarantee guarantee){
        boolean save = guaranteeService.save(guarantee);
        return R.ok().data("save",save);
    }

    /**
     * 删除
     * @return
     */
    @ApiOperation(value="删除",notes="")
    @PostMapping("delete")
    public R delete(@RequestParam String orderNo){
        boolean b = guaranteeService.removeById(orderNo);
        return R.ok().data("delete",b);
    }

}

