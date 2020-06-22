package com.hpf.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 以RestTemplate方式 开始远程调用时，降级整合Hystrix处理
 * */

@Service
public class RestUserServices {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "back")
    public String alive(){
        String url ="http://provider/alive";
        String str = restTemplate.getForObject(url, String.class);
        return str;

    }
    public String  back(){
        System.out.println("rest降级处理······················");

        return "rest降级处理······················";
    }
}
