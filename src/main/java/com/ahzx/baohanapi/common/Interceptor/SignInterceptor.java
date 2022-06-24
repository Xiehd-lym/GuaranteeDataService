package com.ahzx.baohanapi.common.Interceptor;

import cn.hutool.crypto.digest.DigestUtil;
import com.ahzx.baohanapi.common.result.Result;
import com.ahzx.baohanapi.common.util.ServletUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Author xiehd
 * @Date 2022 06 24
 **/
@Component
@Slf4j
public class SignInterceptor implements HandlerInterceptor {

    @Value("${sign.appid}")
    private String appid;

    @Value("${sign.appkey}")
    private String appkey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        RequestWrapper requestWrapper = new RequestWrapper(request);

        String body = requestWrapper.getBody();

        Map<String,Object> jsonMap = JSON.parseObject(body, TreeMap.class);

        if (jsonMap == null){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("appid不能为空")));
            return false;
        }

        Object appidKey = jsonMap.get("appid");
        if (Objects.isNull(appidKey)){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("appid不能为空")));
            return false;
        }

        if (!String.valueOf(appid).equals(appidKey.toString())){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("appid错误")));
            return false;
        }

        Object sign = jsonMap.get("sign");
        if (Objects.isNull(sign)){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("签名不能为空")));
            return false;
        }

        Object applyno = jsonMap.get("applyno");
        if (applyno==null){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("applyno不能为空")));
            return false;
        }

        Object channel = jsonMap.get("channel");
        if (channel==null){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("channel不能为空")));
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Object> entry : jsonMap.entrySet()){
            String key = entry.getKey();
            if (!"sign".equals(key)){
                String value = String.valueOf(entry.getValue());
                if (!StringUtils.isEmpty(value)){
                    sb.append("&").append(key).append("=").append(value);
                }
            }
        }


        String stringA = sb.toString().replaceFirst("&", "");
        String stringSignTemp = stringA + "&" + appkey + appkey;

        log.info("打印参数：{}",stringSignTemp);
//        将签名使用MD5加密，并全部字母变成大写
        String signValue = DigestUtil.md5Hex(stringSignTemp).toUpperCase();

        log.info("打印sign:{}",signValue);

        if (!signValue.equals(sign)){
            ServletUtil.renderString(response,JSON.toJSONString(Result.error("签名错误")));
            return false;
        }

//        return HandlerInterceptor.super.preHandle(request, response, handler);
//        sign校验无问题，放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
