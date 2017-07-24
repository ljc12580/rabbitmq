package com.eking.wallet.domain.wallet.event;

import com.eking.micro.common.domain.model.DomainEvent;

import java.util.Date;

/**
 * Created by apple on 2017/7/10.
 */
public class WalletPaySuccessEvent implements DomainEvent {

    private Integer orderID;
    private int eventVersion;
    private Date occurredOn;

    @Override
    public int eventVersion() {
        return 1;
    }

    @Override
    public Date occurredOn() {
        return new Date();
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public WalletPaySuccessEvent(Integer orderID,int eventVersion,Date occurredOn){
        setOrderID(orderID);
        setEventVersion(eventVersion);
        setOccurredOn(occurredOn);

    }

    public int getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(int eventVersion) {
        this.eventVersion = eventVersion;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }
}
