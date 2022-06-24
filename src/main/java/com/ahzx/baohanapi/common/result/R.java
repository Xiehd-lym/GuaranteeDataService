package com.ahzx.baohanapi.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value = "全局统一返回结果")
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    public R() {
    }

    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEum.SUCCESS.getCode());
        r.setMessage(ResultCodeEum.SUCCESS.getMessage());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEum.ERROR.getSuccess());
        r.setCode(ResultCodeEum.ERROR.getCode());
        r.setMessage(ResultCodeEum.ERROR.getMessage());
        return r;
    }

    public static R setResult(ResultCodeEum resultCodeEum) {
        R r = new R();
        r.setSuccess(resultCodeEum.getSuccess());
        r.setCode(resultCodeEum.getCode());
        r.setMessage(resultCodeEum.getMessage());
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code) {
//
        this.setCode(code);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}