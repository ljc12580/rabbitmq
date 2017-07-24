package com.eking.order.domain.order.model;

import java.math.BigDecimal;

/**
 * Created by 童春 on 2017/7/10.
 */
public class Order{
    private Integer OrderID;
    private Integer BuyProductNum;
    private BigDecimal Price;
    private Integer Status;
    private Integer PurchaseID;
    private Integer ProductID;
    private String processId;
    private boolean isOrderSucess;

    public Order(Integer orderID, Integer buyProductNum, BigDecimal price, Integer status, Integer purchaseID,Integer productID) {
        setOrderID(orderID);
        setBuyProductNum(buyProductNum);
        setPrice(price);
        setStatus(status);
        setPurchaseID(purchaseID);
        setProductID(productID);
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Integer getBuyProductNum() {
        return BuyProductNum;
    }

    public void setBuyProductNum(Integer buyProductNum) {
        if(buyProductNum == null || buyProductNum <=0)
        {
            throw new IllegalArgumentException("购买份额不可小于等于0");
        }
        BuyProductNum = buyProductNum;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("价格不能小于0");
        }

        Price = price;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Integer getPurchaseID() {
        return PurchaseID;
    }

    public void setPurchaseID(Integer purchaseID) {
        if(purchaseID == null){
            throw new IllegalArgumentException("购买人不可为空");
        }
        PurchaseID = purchaseID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

//    public MessageProducer messageProducer() {
//        Exchange exchange =
//                Exchange.fanOutInstance(
//                        ConnectionSettings.instance2(),
//                        ExchangeList.ORDER_EXCHANGE_NAME,
//                        true);
//
//        MessageProducer messageProducer =
//                MessageProducer.instance(exchange);
//
//        return messageProducer;
//    }


    public String getProcessId() {
        return processId;
    }

    public boolean isOrderSucess() {
        return isOrderSucess;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public void setOrderSucess(boolean orderSucess) {
        isOrderSucess = orderSucess;
    }
}
