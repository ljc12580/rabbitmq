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

package com.eking.micro.common.notification;

import com.eking.micro.common.CommonTestCase;
import com.eking.micro.common.event.EventStore;
import com.eking.micro.common.persistence.PersistenceManagerProvider;
import com.eking.micro.common.port.adapter.notification.RabbitMQNotificationPublisher;
import com.eking.micro.common.event.MockEventStore;
import com.eking.micro.common.port.adapter.persistence.hibernate.HibernatePublishedNotificationTrackerStore;

public class NotificationPublisherCreationTest extends CommonTestCase {

    public NotificationPublisherCreationTest() {
        super();
    }

    public void testNewNotificationPublisher() throws Exception {

        EventStore eventStore = new MockEventStore(new PersistenceManagerProvider() {});

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
    }
}
