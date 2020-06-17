package com.hpf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Configuration
public class TestController {

   /* @Autowired
    RestTemplate restTemplate;*/

    @Autowired
    DiscoveryClient client;
/*
    @RequestMapping(value = "/router",method = RequestMethod.GET)
    public String router(){
        String name = restTemplate.getForObject("http://service-provider/person/chonor",String.class);
        return name;
    }*/

    @RequestMapping("client")
    public void client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }

    }
}
