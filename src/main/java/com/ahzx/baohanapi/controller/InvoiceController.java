package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Invoice;
import com.ahzx.baohanapi.service.InvoiceService;
import com.ahzx.baohanapi.vo.InvoiceVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发票表 前端控制器
 * </p>
 *  6发票申请
 *  7发票开具通知
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("/baohanapi/invoice")
@Slf4j
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * 6
     * 省综合服务平台向中鑫中科发起发票申请
     */
    @PostMapping("save")
    public R saveInvoice(@RequestBody Invoice invoice) {

//        Invoice invoice = new Invoice();
//        BeanUtils.copyProperties(invoiceVo, invoice);

        invoiceService.saveInvoice(invoice);

        return R.ok();
    }

    /**
     * 7
     * 中鑫中科向省综合服务平台同步发票结果信息
     */

}

