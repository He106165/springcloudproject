package com.hpf.controller;

import com.hpf.userApi.userApi;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController  implements userApi {

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


}
