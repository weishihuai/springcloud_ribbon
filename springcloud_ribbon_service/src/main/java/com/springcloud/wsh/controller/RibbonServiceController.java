package com.springcloud.wsh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    private static Logger logger = LoggerFactory.getLogger(RibbonServiceController.class);

//    @Value("${server.port}")
//    private String port;
//
//    @Value("${eureka.instance.hostname}")
//    private String hostname;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/testRibbonService")
    public String test(@RequestParam String name) {
        //获取当前服务实例
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        String host = serviceInstance.getHost();
        Integer port = serviceInstance.getPort();
        logger.info("name: " + name + ", port:" + port + " host: " + host);
        return "name: " + name + ", port:" + port + " host: " + host;
    }
}
