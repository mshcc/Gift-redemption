package com.siro.producer.utils;

import java.util.UUID;

/**
 * @author mshcc
 * @date 2020/12/24
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}