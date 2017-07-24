package com.eking.order.application;

import com.eking.micro.common.domain.model.process.ProcessId;
import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTracker;
import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTrackerRepository;
import com.eking.order.application.command.PlaceOrderCommand;
import com.eking.order.application.command.RetryOrderCommand;
import com.eking.order.application.command.TimeOutOrderCommand;
import com.eking.order.domain.order.event.PreOrderGeneratedDomainEvent;
import com.eking.order.domain.order.event.PreOrderGeneratedTimeOut;
import com.eking.order.domain.order.model.Order;
import com.eking.order.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 童春 on 2017/7/10.
 */
@Service
public class OrderApplicationService {
    @Resource(name = "OrderRepositoryImpl")
    OrderRepository orderRepository;
    @Autowired
    EventPublish eventPublish;

    public boolean PlaceOrder(PlaceOrderCommand placeOrderCommand) {
        if (placeOrderCommand == null) {
            return false;
        }
        try {
            Order order = new Order(
                    1,
                    placeOrderCommand.getProductNum(),
                    placeOrderCommand.getOrderPrice(),
                    0,
                    placeOrderCommand.getPurchaseID(),
                    placeOrderCommand.getProductID()
            );
            if (orderRepository.GeneratePreOrder(order) > 0) {
                PreOrderGeneratedDomainEvent preOrderGeneratedDomainEvent = new
                        PreOrderGeneratedDomainEvent(1,
                        placeOrderCommand.getProductID(),
                        placeOrderCommand.getProductNum(),
                        new Date(),
                        1);
//                EventPublish eventPublish = new EventPublish();
                eventPublish.publish(preOrderGeneratedDomainEvent);

                SoreTimeTracker();

                return true;
            }
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }


    @Autowired
    private TimeConstrainedProcessTrackerRepository timeConstrainedProcessTrackerRepository;

    public void SoreTimeTracker() {
        PlaceOrderCommand placeOrderCommand = new
                PlaceOrderCommand(100,
                5,
                BigDecimal.valueOf(5000),
                100);

        Order order = new Order(
                1,
                placeOrderCommand.getProductNum(),
                placeOrderCommand.getOrderPrice(),
                0,
                placeOrderCommand.getPurchaseID(),
                placeOrderCommand.getProductID()
        );
        ;
        TimeConstrainedProcessTracker tracker = new TimeConstrainedProcessTracker(
                order.getOrderID().toString(),
                ProcessId.newProcessId(),
                "create pre order:" + order.getOrderID(),
                new Date(),
                1 * 60 * 1000,
                3,
                PreOrderGeneratedTimeOut.class.getName()

        );

        timeConstrainedProcessTrackerRepository.add(tracker);

    }

    public void timeOutPreOrder(TimeOutOrderCommand command) {
        Order order = orderRepository.GetPreOrderByID(command.getOrderID());
        order.setStatus(2);
        orderRepository.update(order);
    }

    public void retryPreOrder(RetryOrderCommand command) {

        PlaceOrderCommand placeOrderCommand = new
                PlaceOrderCommand(10,
                10,
                BigDecimal.valueOf(4000),
                10);

        PreOrderGeneratedDomainEvent preOrderGeneratedDomainEvent = new
                PreOrderGeneratedDomainEvent(1,
                placeOrderCommand.getProductID(),
                placeOrderCommand.getProductNum(),
                new Date(),
                1);
        eventPublish.publish(preOrderGeneratedDomainEvent);
    }


}
