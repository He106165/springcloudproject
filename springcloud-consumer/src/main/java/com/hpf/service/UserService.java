package com.hpf.service;

import com.hpf.fallback.UserFallBack;
import com.hpf.fallback.UserFallBackFactory;
import com.hpf.userApi.userApi;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name = "provider", fallbackFactory = UserFallBackFactory.class)
//@FeignClient(name = "provider", fallback = UserFallBack.class)
public interface UserService extends userApi {
}
