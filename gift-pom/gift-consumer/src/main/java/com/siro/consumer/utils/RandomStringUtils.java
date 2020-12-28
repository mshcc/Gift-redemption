package com.siro.consumer.utils;

import java.util.Random;

/**
 * @author mshcc
 * @date 2020/12/22
 * TODO 随机生成字符序列，用于生成密码加密的盐，以及礼品卡卡号，卡密
 */
public class RandomStringUtils {
    static final String CHAR_SET = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz";
    static final Random RANDOM = new Random();
    public static String getString(Integer length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHAR_SET.charAt(RANDOM.nextInt(CHAR_SET.length())));
        }
        return stringBuilder.toString();
    }
}
