package com.eking.order.domain.order.service;

import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTrackerRepository;
import com.eking.order.application.command.PlaceOrderCommand;
import com.eking.order.application.EventPublish;
import com.eking.order.domain.order.event.OrderPriceGeneratedDomainEvent;
import com.eking.order.domain.order.event.OrderSuccessDomainEvent;
import com.eking.order.domain.order.model.Order;
import com.eking.order.domain.order.repository.OrderRepository;
import com.eking.order.infrastructure.mybatis.impl.order.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

import com.eking.micro.common.domain.model.process.ProcessId;
import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTracker;
import com.eking.order.domain.order.event.PreOrderGeneratedTimeOut;

import java.util.Date;


/**
 * Created by 童春 on 2017/7/10.
 */
@Service
public class OrderService {

    @Autowired
    EventPublish eventPublish;

    public boolean GeneratePreOrder() {

        boolean result = false;

        return result;
    }

    public void CalculateOrderPrice(Integer OrderID) {

        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();

        Order preorder = orderRepository.GetPreOrderByID(OrderID);
        BigDecimal price = preorder.getPrice().subtract(BigDecimal.valueOf(20));
        OrderPriceGeneratedDomainEvent orderPriceGeneratedDomainEvent = new
                OrderPriceGeneratedDomainEvent(1,
                BigDecimal.valueOf(5000),
                10,
                10);
//        EventPublish eventPublish = new EventPublish();
        eventPublish.publish(orderPriceGeneratedDomainEvent);

    }

    public void FinishOrder(Integer OrderID) {
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
        //省略判断订单状态是否已变更()
        if (orderRepository.FinishOrder(OrderID) > 0) {
            OrderSuccessDomainEvent orderSuccessDomainEvent = new
                    OrderSuccessDomainEvent(1, 10, 10);

//           EventPublish eventPublish = new EventPublish();
            eventPublish.publish(orderSuccessDomainEvent);
            timeOutSucsss("1",ProcessId.newProcessId());
        }

    }

    @Autowired
    private TimeConstrainedProcessTrackerRepository timeConstrainedProcessTrackerRepository;

    public void timeOutSucsss(String aTenantid, ProcessId processId) {
        TimeConstrainedProcessTracker tracker = this.timeConstrainedProcessTrackerRepository.trackerOfProcessId(aTenantid, processId);
        tracker.completed();

        timeConstrainedProcessTrackerRepository.save(tracker);
    }

}
