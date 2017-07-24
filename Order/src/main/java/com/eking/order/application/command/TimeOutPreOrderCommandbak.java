package com.eking.order.application.command;

/**
 * Created by liuxingjia on 2017/7/11.
 */
public class TimeOutPreOrderCommandbak {

    private String tenantId;
    private String processId;

    public TimeOutPreOrderCommandbak(String tenantId, String processId) {
        super();
        this.tenantId = tenantId;
        this.processId = processId;
    }

    public TimeOutPreOrderCommandbak() {
        super();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
