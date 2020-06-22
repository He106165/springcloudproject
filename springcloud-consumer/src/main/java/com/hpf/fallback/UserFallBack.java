package com.hpf.fallback;

import com.hpf.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserFallBack implements UserService {
    @Override
    public String isAlive() {
        return "被降级了";
    }

    @Override
    public Map findById(Integer id) {
        return null;
    }

    @Override
    public String getPort() {
        return null;
    }
}
