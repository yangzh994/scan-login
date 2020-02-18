package com.yangzh.controller;


import com.yangzh.cache.CacheManagerUtil;
import com.yangzh.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/info")
    public Map getUserInfo(String token){
        Map map = new HashMap();
        if(token == null || token.length() == 0){
            map.put("code","-1");
            return map;
        }
        String loginToken = (String)CacheManagerUtil.get(token);
        if(loginToken == null || loginToken.length() == 0){
            map.put("code","-1");
            return map;
        }
        User user = (User)CacheManagerUtil.get(loginToken);
        map.put("code","0");
        map.put("data",user);
        return map;
    }
}
