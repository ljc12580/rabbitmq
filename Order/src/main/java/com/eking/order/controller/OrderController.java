package com.eking.order.controller;

import com.eking.micro.common.domain.model.process.ProcessId;
import com.eking.order.application.OrderApplicationService;
import com.eking.order.application.command.PlaceOrderCommand;
import com.eking.order.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by 童春 on 2017/7/10.
 */
@RestController
public class OrderController {
    @Autowired
    OrderApplicationService orderApplicationService;
    @RequestMapping("/order")
    public void Test()
    {
        PlaceOrderCommand placeOrderCommand = new
                PlaceOrderCommand(10,
                                10,
                                BigDecimal.valueOf(4000),
                                10);
        orderApplicationService.PlaceOrder(placeOrderCommand);
    }

    @Autowired
    OrderService orderService;

    @RequestMapping("/out")
    public void testtimeout()
    {
        orderService.timeOutSucsss("1", ProcessId.newProcessId());
    }
}
