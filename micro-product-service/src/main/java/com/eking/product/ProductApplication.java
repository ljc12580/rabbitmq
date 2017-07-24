package com.eking.product;

import com.eking.product.port.PlaceOrderListener;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Jaye on 2017/7/10.
 */
@ComponentScan(value = {"com.eking.micro.common.session.init.hibernate","com.eking.product"})
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {
    @Autowired
    private PlaceOrderListener placeOrderListener;
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
