package com.eking.product.port;

import com.eking.micro.common.notification.NotificationReader;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import com.eking.product.common.constants.Global;
import com.eking.product.domain.model.ProductOrder;
import com.eking.product.domain.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单成功监听
 * Created by Jaye on 2017/7/10.
 */
@Component
public class OrderSuccessListener extends ExchangeListener {
    @Autowired
    private ProductOrderService productOrderService;

    @Override
    protected String exchangeName() {
        return Global.ORDER_EXCHANGE_NAME;
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {
        NotificationReader reader = new NotificationReader(aTextMessage);

        Integer orderId = reader.eventIntegerValue("orderID");
        Integer productId = reader.eventIntegerValue("productID");
        Integer productNumber = reader.eventIntegerValue("productNum");
        ProductOrder productOrder=new ProductOrder(null,
                Integer.toString(orderId),
                Integer.toString(productId),
                productNumber,
                Global.PRODUCT_SOLD);
        productOrderService.updateProductOrder(productOrder);
    }

    @Override
    protected String[] listensTo() {
       return  new String[] {"com.eking.order.domain.order.event.OrderSuccessDomainEvent"};
    }
}
