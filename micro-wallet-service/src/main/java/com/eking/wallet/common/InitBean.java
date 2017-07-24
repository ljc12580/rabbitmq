package com.eking.wallet.common;

import com.eking.micro.common.event.EventStore;
import com.eking.micro.common.port.adapter.notification.RabbitMQNotificationPublisher;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernatePublishedNotificationTrackerStore;
import com.eking.wallet.application.NotificationApplicationService;
import com.eking.wallet.common.exchange.ExchangeList;
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
        return new HibernatePublishedNotificationTrackerStore("WalletPaySuccessEvent");
    }

    @Autowired
    EventStore eventStore;
    @Autowired
    HibernatePublishedNotificationTrackerStore hibernatePublishedNotificationTrackerStore;
    @Bean
    public RabbitMQNotificationPublisher notificationPublisher() {

        return new RabbitMQNotificationPublisher(eventStore,
                hibernatePublishedNotificationTrackerStore,
                ExchangeList.WALLET_EXCHANGE_NAME);
    }

    @Bean
    public NotificationApplicationService notificationApplicationService()
    {
        return new NotificationApplicationService();
    }

}

