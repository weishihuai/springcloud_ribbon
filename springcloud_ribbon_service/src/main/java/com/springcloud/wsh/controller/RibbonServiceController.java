package com.springcloud.wsh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ribbon 服务提供者测试Controller
 *
 * @author weishihuai
 * @date 2018/9/9
 */
@RestController
public class RibbonServiceController {

    @Value("${server.port}")
    private String port;

    @Value("${eureka.instance.hostname}")
    private String hostname;

    @RequestMapping("/testRibbonService")
    public String test(@RequestParam String name) {
        return "name: " + name + ", port:" + port + " hostname: " + hostname;
    }
}
