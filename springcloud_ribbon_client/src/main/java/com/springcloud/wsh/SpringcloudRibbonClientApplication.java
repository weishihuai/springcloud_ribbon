package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon负载均衡客户端需向spring ioc容器注入RestTemplate
 * Spring Cloud服务调用主要有两种：(Ribbon + RestTemplate) / Feign远程服务调用
 *
 * @author weishihuai
 * @date 2018/09/09 21:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonClientApplication.class, args);
    }

    /**
     * 说明: @LoadBalanced注解主要是开启RestTemplate负载均衡的功能
     * 注入ioc容器
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
