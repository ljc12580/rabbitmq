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

package com.eking.micro.common.port.adapter.messaging.rabbitmq;

import java.util.Date;

import com.eking.micro.common.CommonTestCase;
import com.eking.micro.common.domain.model.DomainEvent;
import com.eking.micro.common.event.EventStore;
import com.eking.micro.common.notification.NotificationPublisher;
import com.eking.micro.common.persistence.PersistenceManagerProvider;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernateEventStore;
import com.eking.micro.common.domain.model.DomainEventPublisher;
import com.eking.micro.common.event.TestableDomainEvent;
import com.eking.micro.common.notification.PublishedNotificationTrackerStore;
import com.eking.micro.common.port.adapter.notification.RabbitMQNotificationPublisher;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernatePublishedNotificationTrackerStore;

public class RabbitMQNotificationPublisherTest extends CommonTestCase {

    public RabbitMQNotificationPublisherTest() {
        super();
    }

    public void testPublishNotifications() throws Exception {
        EventStore eventStore = this.eventStore();

        assertNotNull(eventStore);

        PublishedNotificationTrackerStore publishedNotificationTrackerStore =
                new HibernatePublishedNotificationTrackerStore(
                        new PersistenceManagerProvider(this.session()),
                        "unit.test");

        NotificationPublisher notificationPublisher =
                new RabbitMQNotificationPublisher(
                        eventStore,
                        publishedNotificationTrackerStore,
                        "unit.test");

        assertNotNull(notificationPublisher);

        notificationPublisher.publishNotifications();
    }

    @Override
    protected void setUp() throws Exception {
        DomainEventPublisher.instance().reset();

        super.setUp();

        // always start with at least 20 events

        EventStore eventStore = this.eventStore();

        long startingDomainEventId = (new Date()).getTime();

        for (int idx = 0; idx < 20; ++idx) {
            long domainEventId = startingDomainEventId + 1;

            DomainEvent event = new TestableDomainEvent(domainEventId, "name" + domainEventId);

            eventStore.append(event);
        }
    }

    private EventStore eventStore() {
        EventStore eventStore = new HibernateEventStore(new PersistenceManagerProvider(this.session()));

        assertNotNull(eventStore);

        return eventStore;
    }
}
