package com.siro.demo.utils;

import java.util.Random;

/**
 * @author mshcc
 * @date 2020/12/22
 * TODO 工具类，用于生成兑换码
 */
public class RedemptionCodeGeneration {
    static String string = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-/\\";
    static String string1 = "0123456789";
    static Random random = new Random();
    static final Integer KEY_LEN = 20;
    static final Integer PASSWORD_LEN = 10;

    /**
     * @return 兑换码卡号
     */
    static String getKey() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < KEY_LEN; i++) {
            stringBuilder.append(string.charAt(random.nextInt(string.length())));
        }
        return stringBuilder.toString();
    }

    /**
     * @return 兑换码密码
     */
    static String getPassword() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < PASSWORD_LEN; i++) {
            stringBuilder.append(string.charAt(random.nextInt(string.length())));
        }
        return stringBuilder.toString();
    }
}
