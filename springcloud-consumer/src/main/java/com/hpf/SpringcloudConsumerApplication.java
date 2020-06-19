package com.hpf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }


    @Bean
    @LoadBalanced//初始化ribbon
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }

    /**
     * f负载均衡
     * */
//    @Bean
//    public IRule myRule(){
////        return new RetryRule();
////        return new RoundRobinRule();//轮询
//        return new RandomRule();//随机
//    }
}
