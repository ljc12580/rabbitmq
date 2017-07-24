package com.eking.order.application.command;

import java.math.BigDecimal;

/**
 * Created by 童春 on 2017/7/10.
 */
public class RetryOrderCommand {

    private Integer OrderID;
    private String processId;

    public RetryOrderCommand(String processId,Integer OrderID) {
        this.setProcessId(processId);
        this.setOrderID(OrderID);
    }


    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getProcessId() {

        return processId;
    }
    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }
}
