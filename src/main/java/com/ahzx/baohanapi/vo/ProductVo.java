package com.ahzx.baohanapi.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Blob;

/**
 * @Author xiehd
 * @Date 2022 06 27
 **/
@Data
public class ProductVo {
    private String appid;

    private String sign;

    private String applyno;

    private String channel;

    @ApiModelProperty(value = "省综合服务平台产品id标识")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品状态（1：正常，0：下架）")
    private String productStatus;

    @ApiModelProperty(value = "金融产品类型")
    private String productType;

    @ApiModelProperty(value = "产品介绍描述")
    private String productDesc;

    @ApiModelProperty(value = "金融机构名称")
    private String institutionName;

    @ApiModelProperty(value = "金融机构类型")
    private String institutionType;

    @ApiModelProperty(value = "费率列表")
    private String rateList;

    @ApiModelProperty(value = "适用区域的行政区域代码")
    private String limitArea;

    @ApiModelProperty(value = "最大保证金金额")
    private String limitMaxBond;

    @ApiModelProperty(value = "产品特色描述")
    private String productFeaturesDesc;

    @ApiModelProperty(value = "申请条件描述")
    private String applyConditionDesc;

    @ApiModelProperty(value = "提交材料描述")
    private String fileDesc;

    @ApiModelProperty(value = "适用客户描述")
    private String customerDesc;

    @ApiModelProperty(value = "产品来源")
    private String source;

//    @ApiModelProperty(value = "产品图片文件的base64码")
//    private Blob productPicture;
}
