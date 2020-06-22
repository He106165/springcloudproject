package com.hpf.userApi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 定义provider里的接口
 * */

//@RequestMapping("/User")
public interface userApi {

        /**
         *
         * @return
         * */
        @GetMapping("/isAlive")
        public String isAlive();

        @GetMapping("/findById")
        public Map findById(@RequestParam("id") Integer id);

        @GetMapping("port")
        public String getPort();
}
