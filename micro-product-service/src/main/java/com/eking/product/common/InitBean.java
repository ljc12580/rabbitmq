package com.eking.product.common;

import com.eking.micro.common.event.EventStore;
import com.eking.micro.common.port.adapter.notification.RabbitMQNotificationPublisher;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernatePublishedNotificationTrackerStore;
import com.eking.product.domain.service.NotificationApplicationService;
import com.eking.product.common.constants.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 童春 on 2017/7/7.
 */
@Component
public class InitBean {

    @Bean
    public HibernatePublishedNotificationTrackerStore hibernatePublishedNotificationTrackerStore() {
        return new HibernatePublishedNotificationTrackerStore("ProductLockedSuccessEvent");
    }

    @Autowired
    EventStore eventStore;
    @Autowired
    HibernatePublishedNotificationTrackerStore hibernatePublishedNotificationTrackerStore;
    @Bean
    public RabbitMQNotificationPublisher notificationPublisher() {

        return new RabbitMQNotificationPublisher(eventStore,
                hibernatePublishedNotificationTrackerStore,
                Global.PRODUCT_EXCHANGE_NAME);
    }

    @Bean
    public NotificationApplicationService notificationApplicationService()
    {
        return new NotificationApplicationService();
    }

}

