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

package com.eking.order.application;

import java.util.Collection;

import com.eking.micro.common.annoation.DomainEventAspect;
import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTracker;
import com.eking.micro.common.domain.model.process.TimeConstrainedProcessTrackerRepository;

public class ProcessApplicationService {

    private TimeConstrainedProcessTrackerRepository processTrackerRepository;

    public ProcessApplicationService(
            TimeConstrainedProcessTrackerRepository aProcessorTrackerRepository) {

        super();

        this.processTrackerRepository = aProcessorTrackerRepository;
    }

    public void checkForTimedOutProcesses() {
        try {
            Collection<TimeConstrainedProcessTracker> trackers =
                    this.processTrackerRepository().allTimedOut();

            for (TimeConstrainedProcessTracker tracker : trackers) {
                tracker.informProcessTimedOut();

                this.processTrackerRepository().save(tracker);
            }


        } catch (RuntimeException e) {

            int test=1;
        }
    }

    private TimeConstrainedProcessTrackerRepository processTrackerRepository() {
        return this.processTrackerRepository;
    }
}
