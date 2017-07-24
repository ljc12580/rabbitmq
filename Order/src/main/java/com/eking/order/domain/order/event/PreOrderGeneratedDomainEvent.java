package com.eking.order.domain.order.event;

import com.eking.micro.common.domain.model.DomainEvent;

import java.util.Date;

/**
 * Created by 童春 on 2017/7/10.
 */
public class PreOrderGeneratedDomainEvent implements DomainEvent {


    private Integer orderID;
    private Integer productID;
    private Integer productNum;
    private Date occurredOn;
    private int eventVersion;

    public PreOrderGeneratedDomainEvent(Integer orderID, Integer productID, Integer productNum, Date occurredOn, int eventVersion) {
        setOccurredOn(occurredOn);
        setProductID(productID);
        setEventVersion(eventVersion);
        setOrderID(orderID);
        setProductNum(productNum);
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
    @Override
    public int eventVersion() {
        return 1;
    }

    @Override
    public Date occurredOn() {
        return new Date();
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    public int getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(int eventVersion) {
        this.eventVersion = eventVersion;
    }
}
