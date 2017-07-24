package com.eking.order.common.schedule;

import com.eking.micro.common.annoation.DomainEventAspect;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernateTimeConstrainedProcessTrackerRepository;
import com.eking.order.application.NotificationApplicationService;
import com.eking.order.application.ProcessApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by 童春 on 2017/7/10.
 */
@Configuration
@EnableScheduling
public class NotifySchedule {

    @Autowired
    NotificationApplicationService notificationApplicationService;

    @Autowired
    HibernateTimeConstrainedProcessTrackerRepository timeConstrainedProcessTrackerRepository;

    //@Scheduled(cron = "0/3 * * * * ?") // 每3秒执行一次
    @Scheduled(fixedDelay = 200)//每200毫秒执行一次
    @DomainEventAspect
    public void NotifyToRabbitMQ() {
        notificationApplicationService.publishNotifications();

        ProcessApplicationService processApplicationService = new ProcessApplicationService(timeConstrainedProcessTrackerRepository);
        processApplicationService.checkForTimedOutProcesses();
    }
}
