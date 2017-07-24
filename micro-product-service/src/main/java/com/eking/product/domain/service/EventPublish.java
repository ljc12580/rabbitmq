package com.eking.product.domain.service;

import com.eking.micro.common.annoation.DomainEventAspect;
import com.eking.micro.common.domain.model.DomainEvent;
import com.eking.micro.common.domain.model.DomainEventPublisher;
import com.eking.micro.common.notification.Notification;
import com.eking.micro.common.notification.NotificationSerializer;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.MessageParameters;
import com.eking.product.domain.event.ProductLockedSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Created by 童春 on 2017/7/10.
 */
@Component
public class EventPublish {

    @DomainEventAspect
    public void publish(DomainEvent productLockedSuccessEvent) {
        //通知
        Notification notification =
                new Notification(10, productLockedSuccessEvent);

        //消息参数
        MessageParameters messageParameters =
                MessageParameters.durableTextParameters(
                        notification.typeName(),
                        Long.toString(notification.notificationId()),
                        notification.occurredOn());

        //序列化通知
        String serializedNotification =
                NotificationSerializer.instance().serialize(notification);

        DomainEventPublisher.instance().publish(productLockedSuccessEvent);
    }
}
