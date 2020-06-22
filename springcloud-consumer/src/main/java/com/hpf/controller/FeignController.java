package com.hpf.controller;


import com.hpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeignController {

    @Autowired
    /***/
    UserService userService;

    @Value("${server.port}")
    String port;


    @GetMapping("/alive")
    public String alive() {

        return userService.isAlive();
    }

    @GetMapping("/findById")
    public Map findById(@RequestParam("id") Integer id) {

        return userService.findById(id);
    }

    @GetMapping("getport")
    public String getPort(){
        return "consumer端口  "+port+userService.getPort();
    }
}
