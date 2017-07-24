package com.eking.product.port;

import com.eking.micro.common.notification.NotificationReader;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import com.eking.product.common.constants.Global;
import com.eking.product.domain.event.ProductLockedSuccessEvent;
import com.eking.product.domain.model.ProductOrder;
import com.eking.product.domain.service.EventPublish;
import com.eking.product.domain.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 下单监听
 * Created by Jaye on 2017/7/10.
 */
@Component
public class PlaceOrderListener extends ExchangeListener {

    @Autowired
    private ProductOrderService productOrderService;

    @Override
    protected String exchangeName() {
        return Global.ORDER_EXCHANGE_NAME;  //监听预订单已生成事件
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {
        NotificationReader reader = new NotificationReader(aTextMessage);
//        String tenantId = reader.eventStringValue("tenant.id");
        Integer orderId = reader.eventIntegerValue("orderID");
        Integer productId = reader.eventIntegerValue("productID");
        Integer productNumber = reader.eventIntegerValue("productNum");
        ProductOrder productOrder=new ProductOrder();
        productOrder.setOrderId(Integer.toString(orderId));
        productOrder.setProductId(Integer.toString(productId));
        productOrder.setProductNumber(productNumber);
        if(productOrderService.lockedProduct(productOrder)){
            //发布成功消息
            productOrderService.publihSuccessEvent(orderId);

//            ProductLockedSuccessEvent productLockedSuccessEvent = new
//                    ProductLockedSuccessEvent(orderId,
//                    new Date(),
//                    1);
//            EventPublish eventPublish = new EventPublish();
//            eventPublish.publish(productLockedSuccessEvent);

        }
    }

    @Override
    protected String[] listensTo() {
        return new String[] {"com.eking.order.domain.order.event.PreOrderGeneratedDomainEvent"};
    }
}
