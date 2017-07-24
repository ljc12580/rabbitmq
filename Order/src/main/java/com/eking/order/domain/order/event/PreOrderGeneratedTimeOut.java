package com.eking.order.domain.order.event;

import com.eking.micro.common.domain.model.process.ProcessId;
import com.eking.micro.common.domain.model.process.ProcessTimedOut;

/**
 * Created by liuxingjia on 2017/7/11.
 */


public class PreOrderGeneratedTimeOut extends ProcessTimedOut {


    public PreOrderGeneratedTimeOut(String aTenantId, ProcessId aProcessId, int aTotalRetriesPermitted, int aRetryCount) {
        super(aTenantId, aProcessId, aTotalRetriesPermitted, aRetryCount);
    }
}
