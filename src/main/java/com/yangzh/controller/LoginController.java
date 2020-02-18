package com.yangzh.controller;

import com.yangzh.cache.CacheManagerUtil;
import com.yangzh.model.User;
import com.yangzh.utils.GenerateTokenUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public Map login(User user){
        Map map = new HashMap();
        if("root".equals(user.getNickname()) && "123456".equals(user.getPassword())){
            //登录成功
            String loginToken = GenerateTokenUtil.createToken();

            CacheManagerUtil.set(loginToken,user);

            map.put("code","0");
            map.put("message","登录成功!");
            map.put("token",loginToken);
            return map;
        }
        map.put("code","-1");
        map.put("message","登录失败!账户或密码错误!");
        return map;
    }

}
