package com.eking.order.port.message.rabbitmq;

import com.eking.micro.common.notification.NotificationReader;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import com.eking.order.common.exchange.ExchangeList;
import com.eking.order.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 童春 on 2017/7/10.
 */
@Component
public class PayResultListener extends ExchangeListener {
    @Autowired
    OrderService orderService;
//    OrderService orderService=new OrderService();

    @Override
    protected String exchangeName() {
        return ExchangeList.WALLET_EXCHANGE_NAME;
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {
        NotificationReader reader = new NotificationReader(aTextMessage);

//        String productid = reader.eventStringValue("tenant.id");

        Integer orderID = reader.eventIntegerValue("orderID");
//        OrderService orderService = new OrderService();
        orderService.FinishOrder(orderID);

    }

    @Override
    protected String[] listensTo() {
        return new String[] {
                "com.eking.wallet.domain.wallet.event.WalletPaySuccessEvent"
        };
    }
}
