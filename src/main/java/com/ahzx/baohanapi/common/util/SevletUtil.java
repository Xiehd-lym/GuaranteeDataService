package com.ahzx.baohanapi.common.util;

import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet工具
 */
public class SevletUtil {

    // 获取request
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }


    // 获取ServletRequestAttributes
    public static ServletRequestAttributes getRequestAttributes() {
        return null;
    }

    public static String renderString(HttpServletResponse response,String string) {
        return null;
    }

}
