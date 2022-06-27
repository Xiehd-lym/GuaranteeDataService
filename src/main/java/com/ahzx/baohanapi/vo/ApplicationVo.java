package com.ahzx.baohanapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author xiehd
 * @Date 2022 06 27
 **/
@Data
public class ApplicationVo {

    private String appid;

    private String sign;

    private String applyno;

    private String channel;

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "省综合服务平台产品id标识")
    private String productId;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "企业统一社会信用代码")
    private String companyCreditCode;

    @ApiModelProperty(value = "企业地址")
    private String companyAddress;

    @ApiModelProperty(value = "经办人姓名")
    private String handlerName;

    @ApiModelProperty(value = "经办人手机号")
    private String handlerMobile;
}
