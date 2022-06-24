package com.ahzx.baohanapi.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    public static String signature() {

        SignUtils signUtils = new SignUtils();
        String timestamp = signUtils.getTimestamp();

        String uuid = UUID.randomUUID().toString().trim().replace("-", "");

        String baseString = "accessKeyId=" + accessKeyId + "&appId=" + appId +
                "&timestamp=" + timestamp + "&uuid=" + uuid;

        return cn.hutool.crypto.SmUtil.sm3(keySecret + baseString);
    }

    public String getTimestamp() {
        // 生成时间戳
        Long timestampLong = System.currentTimeMillis();

        String timestampStr = String.valueOf(timestampLong);

        return timestampStr;
    }

}
