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
 *  3申请结果通知
 *  4审核结果通知
 *  5出函通知
 *
 * 8退保申请
 * 9退保通知
 * 10理赔申请
 * 11理赔通知
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("/baohanapi/guarantee")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    /**
     * 3
     * 用户在中鑫中科平台申请成功后，
     * 需将用户申请信息同步省综合服务平台
     * @return
     */
    @ApiOperation(value="新增申请信息",notes="")
    @PostMapping("save")
    public R save(@RequestBody Guarantee guarantee){
        boolean save = guaranteeService.save(guarantee);
        return R.ok().data("save",save);
    }

    /**
     * 4
     * 金融机构把审核结果通知中鑫中科之后，
     * 中鑫中科将审核结果同步给省综合服务平台
     */


    /**
     * 5
     * 金融机构把保函给中鑫中科之后，
     * 中鑫中科将数据回传给省综合服务平台
     */

    /**
     * 8
     * 省综合服务平台向中鑫中科发起退保申请
     */

    /**
     * 9
     * 中鑫中科向省综合服务平台同步退保结果信息
     */

    /**
     * 10
     * 省综合服务平台向中鑫中科发起理赔申请
     */

    /**
     * 11
     * 中鑫中科向省综合服务平台同步理赔结果信息
     */

}

