package com.ahzx.baohanapi.common.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true,200,"成功"),
    ERROR(false,500,"失败"),

    UNKOWN_REASON(false,20001,"未知错误"),

    BAD_SQL_GRAMMAR(false,21001,"sql语法错误"),
    JSON_PARSE_ERROR(false,21002,"json解析异常"),
    PARAM_ERROR(false,21003,"参数不正确"),

    URL_ENCODE_ERROR(false,22001,"URL编码失败"),
    ILLEGAL_CALLBACK_REQUEST_ERROR(false,22002,"非法回调请求"),
    FETCH_USERINFO_ERROR(false,22003,"获取用户信息失败"),

    GATEWAY_ERROR(false,23001,"服务不能访问"),
    PHONE_ERROR(false,23002,"手机号不正确"),
    ACCOUNT_ERROR(false,23003,"账号不正确");

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
