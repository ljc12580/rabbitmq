package com.eking.order.domain.order.event;

import com.eking.micro.common.domain.model.DomainEvent;

import java.util.Date;

/**
 * Created by 童春 on 2017/7/10.
 */
public class OrderSuccessDomainEvent implements DomainEvent {

    private Integer orderID;
    private Integer productID;
    private Integer productNum;

    public OrderSuccessDomainEvent(Integer orderID, Integer productID, Integer productNum) {
        this.orderID = orderID;
        this.productID = productID;
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
}
