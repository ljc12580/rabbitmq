//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.eking.order.port.message.rabbitmq;

import com.eking.micro.common.notification.Notification;
import com.eking.micro.common.notification.NotificationReader;
import com.eking.micro.common.notification.NotificationSerializer;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import com.eking.order.application.OrderApplicationService;
import com.eking.order.application.command.RetryOrderCommand;
import com.eking.order.application.command.TimeOutOrderCommand;
import com.eking.order.common.exchange.ExchangeList;
import com.eking.order.domain.order.event.PreOrderGeneratedTimeOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
public class RabbitMQPreOrderRetryListener extends ExchangeListener {

    @Autowired
    OrderApplicationService orderApplicationService;
    // private OrderApplicationService orderApplicationService =new OrderApplicationService();

//    public RabbitMQPreOrderRetryListener(
//            OrderApplicationService aOrderApplicationService) {
//
//        super();
//
//        this.orderApplicationService = aOrderApplicationService;
//    }

    @Override
    protected String exchangeName() {
        return ExchangeList.ORDER_EXCHANGE_NAME;
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {

        NotificationReader reader = new NotificationReader(aTextMessage);

        String pricessid = reader.eventStringValue(
                "processId.id");

        boolean hasFullyTimedOut =reader.eventBooleanValue("hasFullyTimedOut");

        if (hasFullyTimedOut)
        {
            orderApplicationService.timeOutPreOrder(new TimeOutOrderCommand(pricessid,1,new Date()));
        }
        else
        {
            orderApplicationService.retryPreOrder(new RetryOrderCommand(pricessid,1));
        }
//        PreOrderGeneratedTimeOut event = notification.event();
//
//        if (event.hasFullyTimedOut()) {
//            this.orderApplicationService().timeOutPreOrder(new TimeOutOrderCommand(event.processId().id(),1,new Date()));
//        } else {
//            this.orderApplicationService().retryPreOrder(new RetryOrderCommand(event.processId().id(),1));}
    }


    @Override
    protected String[] listensTo() {
        return new String[]{
                "com.eking.order.domain.order.event.PreOrderGeneratedTimeOut",
                "PreOrderGeneratedDomainEvent"
        };
    }


}
