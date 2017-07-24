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

import com.eking.micro.common.domain.model.DomainEvent;

import java.util.Date;

public class ProcessTimedOut implements DomainEvent {

    private int eventVersion;
    private Date occurredOn;
    private ProcessId processId;
    private int retryCount;
    private String tenantId;
    private int totalRetriesPermitted;
    private boolean hasFullyTimedOut;


    public ProcessTimedOut(
            String aTenantId,
            ProcessId aProcessId,
            int aTotalRetriesPermitted,
            int aRetryCount) {
        super();

        this.eventVersion = 1;
        this.occurredOn = new Date();
        this.processId = aProcessId;
        this.retryCount = aRetryCount;
        this.tenantId = aTenantId;
        this.totalRetriesPermitted = aTotalRetriesPermitted;
        this.hasFullyTimedOut=!this.allowsRetries() || this.totalRetriesReached();
    }

    public boolean allowsRetries() {
        return this.totalRetriesPermitted() > 0;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    public boolean hasFullyTimedOut() {
        return this.hasFullyTimedOut;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }

    public ProcessId processId() {
        return processId;
    }

    public int retryCount() {
        return retryCount;
    }

    public String tenantId() {
        return tenantId;
    }

    public int totalRetriesPermitted() {
        return totalRetriesPermitted;
    }

    public boolean totalRetriesReached() {
        return this.retryCount() >= this.totalRetriesPermitted();
    }
}
