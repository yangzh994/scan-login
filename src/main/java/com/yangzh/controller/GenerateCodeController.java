package com.yangzh.controller;

import com.yangzh.cache.CacheManagerUtil;
import com.yangzh.utils.GenerateTokenUtil;
import com.yangzh.utils.QrCodeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/generateCode")
public class GenerateCodeController {

    @RequestMapping("/create")
    public Map generateCode(){
        String token = GenerateTokenUtil.createToken();
        //生成的token 放入cache
        CacheManagerUtil.set(token,null);
        //生成二维码,返回给前端
        String binary = QrCodeUtils.creatRrCode("http://localhost:8080/ScanLogin/login?token=" + token, 200,200);
        //返回给前端
        Map map = new HashMap();
        map.put("qrcode",binary);
        map.put("token",token);
        return map;
    }

}
