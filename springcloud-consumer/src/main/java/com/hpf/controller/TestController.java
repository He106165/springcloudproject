package com.hpf.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
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

    @Autowired
    EurekaClient client2;
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
            System.out.println("1     "+service);
        }
        List<InstanceInfo> provider = client2.getInstancesById("provider:81");
        if(provider.size()>0){
            InstanceInfo instanceInfo= provider.get(0);
            String url =	"http://" + instanceInfo.getHostName() +":"+ instanceInfo.getPort() + "/HI";

            System.out.println("url:" + url);

            RestTemplate restTemplate = new RestTemplate();

            String respStr = restTemplate.getForObject(url, String.class);

            System.out.println("respStr"  + respStr);

        }

    }
}
