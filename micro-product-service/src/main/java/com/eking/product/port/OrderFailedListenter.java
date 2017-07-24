package com.eking.product.port;

import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;

/**
 * Created by Jaye on 2017/7/10.
 */
public class OrderFailedListenter extends ExchangeListener {
    @Override
    protected String exchangeName() {
        return null;
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {

    }

    @Override
    protected String[] listensTo() {
        return new String[0];
    }
}
