//package com.eking.order.common;
//
//import com.eking.micro.common.event.EventStore;
//import com.eking.micro.common.port.adapter.notification.RabbitMQNotificationPublisher;
//import com.eking.micro.common.port.adapter.persistence.hibernate.HibernatePublishedNotificationTrackerStore;
//import com.eking.order.application.NotificationApplicationService;
//import com.eking.order.common.exchange.ExchangeList;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
///**
// * Created by 童春 on 2017/7/7.
// */
//@Component
//public class InitBeanPay {
//
//    @Bean
//    public HibernatePublishedNotificationTrackerStore hibernatePublishedNotificationTrackerStore() {
//        return new HibernatePublishedNotificationTrackerStore("com.eking.micro.common.domain.model.DomainEvent.OrderPriceGeneratedDomainEvent");
//    }
//
//    @Autowired
//    EventStore eventStore;
//    @Autowired
//    HibernatePublishedNotificationTrackerStore hibernatePublishedNotificationTrackerStore;
//    @Bean
//    public RabbitMQNotificationPublisher notificationPublisher() {
//
//        return new RabbitMQNotificationPublisher(eventStore,
//                hibernatePublishedNotificationTrackerStore,
//                ExchangeList.ORDER_EXCHANGE_NAME);
//    }
//
//    @Bean
//    public NotificationApplicationService notificationApplicationService()
//    {
//        return new NotificationApplicationService();
//    }
//
//}
//
