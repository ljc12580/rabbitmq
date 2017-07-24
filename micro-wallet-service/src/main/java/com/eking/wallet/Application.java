package com.eking.wallet;

import com.eking.wallet.port.OrderCaculateComplateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by apple on 17/7/10.
 */
@ComponentScan(value = {"com.eking.micro.common.session.init.hibernate","com.eking.wallet"})
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    @Autowired
    OrderCaculateComplateListener orderCaculateComplateListener;
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}
