package com.yangzh.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheManagerUtil {

    private static Map<String,Object> cacheMap = new HashMap<>();

    private CacheManagerUtil(){}


    public static Object get(String key){
        return cacheMap.get(key);
    }

    public static Object set(String key,Object value){
        return cacheMap.put(key,value);
    }

}
