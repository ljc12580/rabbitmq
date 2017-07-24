package com.eking.order;


import com.eking.micro.common.domain.model.process.ProcessId;
import com.eking.order.domain.order.service.OrderService;
import com.eking.order.port.message.rabbitmq.PayResultListener;

import com.eking.order.port.message.rabbitmq.ProductFrozenListener;

import com.eking.order.application.OrderApplicationService;
import com.eking.order.port.message.rabbitmq.RabbitMQPreOrderRetryListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 童春 on 2017/7/10.
 */
@ComponentScan(value = {"com.eking.micro.common.session.init.hibernate", "com.eking.order"})
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Autowired
    ProductFrozenListener productFrozenListener;
    @Autowired
    PayResultListener payResultListener;
    @Autowired
    RabbitMQPreOrderRetryListener rabbitMQPreOrderRetryListener;
}
