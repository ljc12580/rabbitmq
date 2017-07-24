package com.eking.order.application.command;

import java.math.BigDecimal;

/**
 * Created by 童春 on 2017/7/10.
 */
public class PlaceOrderCommand {
    private Integer productID;
    private Integer productNum;
    private BigDecimal orderPrice;
    private Integer purchaseID;

    public PlaceOrderCommand(Integer productID, Integer productNum, BigDecimal orderPrice, Integer purchaseID) {
        this.productID = productID;
        this.productNum = productNum;
        this.orderPrice = orderPrice;
        this.purchaseID = purchaseID;
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
}
