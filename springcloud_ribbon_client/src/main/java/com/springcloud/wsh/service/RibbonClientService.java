package com.springcloud.wsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by weishihuai on 2018/9/9.
 * 使用ribbon + restTemplate调用ribbon-service提供的服务
 * 测试负载均衡的时候需要启动多个服务提供者实例，确认各个实例是否均衡调用。
 *
 * @author weishihuai
 * @date 2018/09/09 21:37
 */
@Service
public class RibbonClientService {

    /**
     * 注入restTemplate
     * restTemplate主要有getForObject/getForEntity/postForObject/postForEntity等常用方法
     */
    @Autowired
    RestTemplate restTemplate;

    public String testRibbonService(String name) {
        //eureka-ribbon-service对应 ribbon-service的applicaton name
        //使用应用名称替代具体的url地址，在ribbon中会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
        //restTemplate.getForObject("http://eureka-ribbon-service/testRibbonService?name={name}", String.class, name);
        return restTemplate.getForObject("http://eureka-ribbon-service/testRibbonService?name=" + name, String.class);
    }

}
