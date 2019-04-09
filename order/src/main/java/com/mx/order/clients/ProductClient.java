package com.mx.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : ShangGuanMingPeng
 * Description :
 * Date :Create in 2019/4/6 16:36
 * Modified By :
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/product/get")
    String productMsg();

}
