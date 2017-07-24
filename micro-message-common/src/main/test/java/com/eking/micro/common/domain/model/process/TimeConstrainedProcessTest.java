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

package com.eking.micro.common.domain.model.process;

import com.eking.micro.common.CommonTestCase;
import com.eking.micro.common.domain.model.DomainEventPublisher;
import com.eking.micro.common.domain.model.DomainEventSubscriber;

public class TimeConstrainedProcessTest extends CommonTestCase {

    private static final String TENANT_ID = "1234567890";

    private TestableTimeConstrainedProcess process;
    private boolean received;

    public TimeConstrainedProcessTest() {
        super();
    }

    public void testCompletedProcess() throws Exception {
        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<TestableTimeConstrainedProcessTimedOut>() {

            @Override
            public void handleEvent(TestableTimeConstrainedProcessTimedOut aDomainEvent) {
                received = true;
                process.informTimeout(aDomainEvent.occurredOn());
            }

            @Override
            public Class<TestableTimeConstrainedProcessTimedOut> subscribedToEventType() {
                return TestableTimeConstrainedProcessTimedOut.class;
            }
        });

        process = new TestableTimeConstrainedProcess(
                TENANT_ID,
                ProcessId.newProcessId(),
                "Testable Time Constrained Process",
                5000L);

        TimeConstrainedProcessTracker tracker =
                process.timeConstrainedProcessTracker();

        process.confirm1();

        assertFalse(received);
        assertFalse(process.isCompleted());
        assertFalse(process.didProcessingComplete());
        assertEquals(Process.ProcessCompletionType.NotCompleted, process.processCompletionType());

        process.confirm2();

        assertFalse(received);
        assertTrue(process.isCompleted());
        assertTrue(process.didProcessingComplete());
        assertEquals(Process.ProcessCompletionType.CompletedNormally, process.processCompletionType());
        assertNull(process.timedOutDate());

        tracker.informProcessTimedOut();

        assertFalse(received);
        assertFalse(process.isTimedOut());
    }
}
