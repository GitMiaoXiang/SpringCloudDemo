package com.mx.order.controller;

import com.mx.order.clients.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : ShangGuanMingPeng
 * Description :
 * Date :Create in 2019/4/6 9:17
 * Modified By :
 */
@RestController
@RequestMapping("/order")
@RefreshScope
@DefaultProperties(defaultFallback="defaultFallback")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;

    @Autowired
    private ProductClient productClient;

    @Value("${evn}")
    private String evn;


    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping("get")
    public String get() {
        //注入LoadBalancerClient方式
//        ServiceInstance product = balancerClient.choose("PRODUCT");
//        String url = String.format("http://$s:$s",product.getHost(),product.getPort());

        //注解方式@LoadBalance
//        String str = restTemplate.getForObject("http://PRODUCT/product/get", String.class);

        //
        String str = productClient.productMsg();
        return str;
    }

    public String defaultFallback(){
        return "太拥挤了！！！！！！！！！！！";
    }

    @GetMapping("config")
    public String config() {
        return evn;
    }

    @GetMapping("1")
    public String config1() {
        return evn;
    }

    @GetMapping("2")
    public String config2() {
        return evn;
    }

    @GetMapping("3")
    public String config3() {
        return evn;
    }

}
