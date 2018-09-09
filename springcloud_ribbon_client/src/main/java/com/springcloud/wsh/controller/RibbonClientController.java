package com.springcloud.wsh.controller;

import com.springcloud.wsh.service.RibbonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weishihuai on 2018/9/9.
 * 用于测试Ribbon客户端负载均衡
 *
 * @author weishihuai
 * @date 2018/09/09 21:37
 */
@RestController
public class RibbonClientController {

    @Autowired
    private RibbonClientService ribbonClientService;

    @RequestMapping("/testRibbonService")
    public String testRibbonService(@RequestParam String name) {
        return ribbonClientService.testRibbonService(name);
    }

}
