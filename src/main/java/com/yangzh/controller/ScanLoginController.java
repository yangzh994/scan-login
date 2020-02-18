package com.yangzh.controller;

import com.yangzh.cache.CacheManagerUtil;
import com.yangzh.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ScanLogin")
public class ScanLoginController {

    @RequestMapping("/login")
    public Map login(HttpServletRequest request,String token){
        Map map = new HashMap();
        //获取登录token
        if(token == null){
            map.put("code","-1");
            map.put("message","网络异常!");
            return map;
        }

        String logintoken = request.getHeader("loginToken");
        if(logintoken == null){
            map.put("code","-1");
            map.put("message","请先登录!");
            return map;
        }

        User user = (User)CacheManagerUtil.get(logintoken);
        if(user == null){
            map.put("code","-1");
            map.put("message","请先登录!");
            return map;
        }

        CacheManagerUtil.set(token,logintoken);
        map.put("code","0");
        map.put("message","成功!");
        return map;
    }

}
