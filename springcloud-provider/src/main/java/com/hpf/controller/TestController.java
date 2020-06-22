package com.hpf.controller;

import com.hpf.userApi.userApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController  implements userApi {


    @Value("${server.port}")
    String port;

    @RequestMapping("HI")
    public String findName( String name){
        return "HI";
    }

    @RequestMapping("getForObj")
    public String getForObj(@RequestParam("name") String name){
        return name;
    }

    @Override
    public String isAlive() {
        return "你真牛逼";
    }

    @Override
    public Map findById(Integer id) {
        Map map=new HashMap();
        map.put("id",id);
        return map;
    }

    @Override
    public String getPort() {
        return "server端  "+port;
    }


}
