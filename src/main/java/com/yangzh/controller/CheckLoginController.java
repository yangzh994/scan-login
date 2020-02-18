package com.yangzh.controller;


import com.yangzh.cache.CacheManagerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/checkLogin")
public class CheckLoginController {

    @RequestMapping("/check")
    public String checkLogin(String token){
        String loginToken = (String)CacheManagerUtil.get(token);
        if(loginToken == null){
            return "-1";
        }
        return loginToken;
    }
}
