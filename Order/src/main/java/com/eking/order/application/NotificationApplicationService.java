package com.eking.order.application;

import com.eking.micro.common.event.EventStore;
import com.eking.micro.common.notification.NotificationLog;
import com.eking.micro.common.notification.NotificationLogFactory;
import com.eking.micro.common.notification.NotificationLogId;
import com.eking.micro.common.notification.NotificationPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 童春 on 2017/7/7.
 */
@Service
public class NotificationApplicationService {
    @Autowired
    private EventStore eventStore;

    @Autowired
    private NotificationPublisher notificationPublisher;

    public NotificationApplicationService() {
        super();
    }

    //@Transactional(readOnly=true)
    public NotificationLog currentNotificationLog() {
        NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

        return factory.createCurrentNotificationLog();
    }

    //@Transactional(readOnly=true)
    public NotificationLog notificationLog(String aNotificationLogId) {
        NotificationLogFactory factory = new NotificationLogFactory(this.eventStore());

        return factory.createNotificationLog(new NotificationLogId(aNotificationLogId));
    }

    //@Transactional
    public void publishNotifications() {
        this.notificationPublisher().publishNotifications();
    }

    protected EventStore eventStore() {
        return this.eventStore;
    }

    protected NotificationPublisher notificationPublisher() {
        return this.notificationPublisher;
    }
}
