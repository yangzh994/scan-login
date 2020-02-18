package com.yangzh.utils;

import java.util.UUID;

public class GenerateTokenUtil {


    private GenerateTokenUtil(){}

    public static String createToken(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
