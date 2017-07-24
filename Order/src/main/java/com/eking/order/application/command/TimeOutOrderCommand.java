package com.eking.order.application.command;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 童春 on 2017/7/10.
 */
public class TimeOutOrderCommand {
    private Integer OrderID;
    private String processId;
    private Date TimeOutDate;


    private Date timedOutDate;

    public TimeOutOrderCommand(String processId, Integer OrderID,Date timedOutDate) {

        this.setProcessId(processId);
        this.setOrderID(OrderID);
        this.setTimedOutDate(timedOutDate);
    }


    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public void setTimedOutDate(Date timedOutDate) {
        this.timedOutDate = timedOutDate;
    }

    public String getProcessId() {
        return processId;
    }

    public Date getTimedOutDate() {
        return timedOutDate;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }
}
