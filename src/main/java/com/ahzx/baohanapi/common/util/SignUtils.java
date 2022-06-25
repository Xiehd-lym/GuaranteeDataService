package com.ahzx.baohanapi.common.util;

import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.time.format.SignStyle;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Component
public class SignUtils {

    private static String appId;

    private static String accessKeyId;

    private static String keySecret;

    @Value("${sign.appid}")
    public void setAppid(String appId) {
        this.appId = appId;
    }

    @Value("${sign.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Value("${sign.keySecret}")
    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    // signature签名生成（SM3加密）
//    public static String signature() {
//
//        SignUtils signUtils = new SignUtils();
//        String timestamp = signUtils.getTimestamp();
//
//        String uuid = UUID.randomUUID().toString().trim().replace("-", "");
//
//        String baseString = "accessKeyId=" + accessKeyId + "&appId=" + appId +
//                "&timestamp=" + timestamp + "&uuid=" + uuid;
//
//        return cn.hutool.crypto.SmUtil.sm3(keySecret + baseString);
//    }

    public static Map<String,Object> createSign(Map<String, Object> params) {
        SignUtils signUtils = new SignUtils();
        String timestamp = signUtils.getTimestamp();
        params.put("appid", appId);
        params.put("timestamp",timestamp);
        StringBuilder sb = new StringBuilder();

        //将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<>(params);
        for (Map.Entry<String, Object> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            if (!StringUtils.isEmpty(value)) {
                sb.append("&").append(key).append("=").append(value);
            }
        }
        String stringA = sb.toString().replaceFirst("&", "");
        String stringSignTemp = stringA + "&" + "appKey=" + accessKeyId;

        String signValue = DigestUtil.md5Hex(stringSignTemp).toUpperCase();
        params.put("sign", signValue);
        return params;
    }

    public String getTimestamp() {
        // 生成时间戳
        Long timestampLong = System.currentTimeMillis();

        String timestampStr = String.valueOf(timestampLong);

        return timestampStr;
    }

}
