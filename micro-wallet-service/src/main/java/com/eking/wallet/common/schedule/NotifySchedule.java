package com.eking.wallet.common.schedule;

import com.eking.wallet.application.NotificationApplicationService;
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

    //@Scheduled(cron = "0/3 * * * * ?") // 每3秒执行一次
    @Scheduled(fixedDelay = 200)//每200毫秒执行一次
    public void NotifyToRabbitMQ()
    {
        notificationApplicationService.publishNotifications();
    }
}
