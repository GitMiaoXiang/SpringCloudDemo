package com.mx.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get")
    public String get() throws InterruptedException {
//        Thread.sleep(4000);
        return "product server";
    }

}
