package com.hpf.fallback;

import com.hpf.userApi.userApi;
import feign.hystrix.FallbackFactory;

import feign.FeignException.InternalServerError;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserFallBackFactory  implements FallbackFactory<userApi> {
    @Override
    public userApi create(Throwable throwable) {

        return new userApi() {
            @Override
            public String isAlive() {
                if(throwable instanceof InternalServerError){

                    return "远程服务器 500" + throwable.getLocalizedMessage();

                }else {

                    return "呵呵";
                }
            }

            @Override
            public Map findById(Integer id) {
                return null;
            }

            @Override
            public String getPort() {
                return null;
            }
        };
    }
}
