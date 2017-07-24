package com.eking.order.domain.order.event;

import com.eking.micro.common.domain.model.DomainEvent;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 童春 on 2017/7/10.
 */
public class OrderPriceGeneratedDomainEvent implements DomainEvent {
    public OrderPriceGeneratedDomainEvent(Integer orderID, BigDecimal orderPrice, Integer purchaseID, Integer productID) {
        this.orderID = orderID;
        this.orderPrice = orderPrice;
        this.purchaseID = purchaseID;
        this.productID = productID;
    }

    @Override
    public int eventVersion() {
        return 1;
    }

    @Override
    public Date occurredOn() {
        return new Date();
    }
    private Integer orderID;
    private BigDecimal orderPrice;
    private Integer purchaseID;
    private Integer productID;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Integer purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }
}
