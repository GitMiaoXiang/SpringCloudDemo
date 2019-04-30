package com.mx.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : ShangGuanMingPeng
 * Description :
 * Date :Create in 2019/4/6 16:36
 * Modified By :
 */
@FeignClient(name = "product",fallback = ProductClient.ProDuctFallBack.class)
public interface ProductClient {

    @GetMapping("/product/get")
    String productMsg();

    @Component
    class ProDuctFallBack implements ProductClient{

        @Override
        public String productMsg() {
            //降级方法
            return "降级了";
        }
    }
}
