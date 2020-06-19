package com.hpf.controller;


import com.hpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeignController {

    @Autowired
            /***/
    UserService userService;

    @GetMapping("/alive")
    public String alive() {

        return userService.isAlive();
    }

    @GetMapping("/findById")
    public Map findById(@RequestParam("id") Integer id) {

        return userService.findById(id);
    }
}
