package com.hpf.service;

import com.hpf.userApi.userApi;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name = "provider")
public interface UserService extends userApi {
}
