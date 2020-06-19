package com.hpf.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@Configuration
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient client;
/*
    @Autowired
    EurekaClient client2;*/
    @Autowired
    LoadBalancerClient lb;

    @Autowired
    DiscoveryClient discoveryClient;



    @RequestMapping("client2")
    public void client(){

        ServiceInstance provider = lb.choose("provider");
        System.out.println(provider);
        String url =	"http://" + provider.getHost() +":"+ provider.getPort() + "/HI";
        System.out.println(url);
    }

      /**
      * 手动负责均衡
      * */

      @RequestMapping("client3")
      public void client3(){
          List<ServiceInstance> instances = discoveryClient.getInstances("provider");
          //随便写个随机数
          int nextInt = new Random().nextInt(instances.size());
          ServiceInstance serviceInstance = instances.get(nextInt);
          System.out.println(serviceInstance);
      }

    @RequestMapping("client4")
    public void client4(){

        String url ="http://provider/HI";
        String resulte = restTemplate.getForObject(url, String.class);
        System.out.println(resulte);

      }
}
