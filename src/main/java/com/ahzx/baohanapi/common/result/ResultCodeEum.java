package com.ahzx.baohanapi.common.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultCodeEum {

    SUCCESS(true,200,"成功"),
    ERROR(false,500,"失败"),


    ;

    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
