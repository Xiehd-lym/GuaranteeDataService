package com.ahzx.baohanapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ahzx.baohanapi.baseModel.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 投保申请表
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Application对象", description="投保申请表")
public class Application extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "省综合服务平台产品id标识")
    @TableField("productId")
    private String productId;

    @ApiModelProperty(value = "企业名称")
    @TableField("companyName")
    private String companyName;

    @ApiModelProperty(value = "企业统一社会信用代码")
    @TableField("companyCreditCode")
    private String companyCreditCode;

    @ApiModelProperty(value = "企业地址")
    @TableField("companyAddress")
    private String companyAddress;

    @ApiModelProperty(value = "经办人姓名")
    @TableField("handlerName")
    private String handlerName;

    @ApiModelProperty(value = "经办人手机号")
    @TableField("handlerMobile")
    private String handlerMobile;

    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    private Boolean deleteFlag;


}
