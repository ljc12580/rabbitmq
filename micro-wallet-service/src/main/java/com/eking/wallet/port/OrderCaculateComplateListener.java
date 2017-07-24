package com.eking.wallet.port;

import com.eking.micro.common.notification.NotificationReader;
import com.eking.micro.common.port.adapter.messaging.rabbitmq.ExchangeListener;
import com.eking.wallet.common.exchange.ExchangeList;
import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.repository.WalletRepository;
import com.eking.wallet.domain.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by apple on 17/7/11.
 */
@Component
public class OrderCaculateComplateListener extends ExchangeListener{

    @Autowired
    WalletRepository walletRepository;
    @Autowired
    WalletService walletService;

    @Override
    protected String exchangeName() {
        return ExchangeList.ORDER_EXCHANGE_NAME;
    }

    @Override
    protected void filteredDispatch(String aType, String aTextMessage) {
        NotificationReader reader=new NotificationReader(aTextMessage);
        int userid=reader.eventIntegerValue("purchaseID");
        BigDecimal money=reader.eventBigDecimalValue("orderPrice");
        Wallet wallet=new Wallet();
        wallet.setMoney(money);
        wallet.setUserid(userid);
        wallet.setPay_time(new Date().toString());
//        double debit=walletRepository.query(userid).getMoney();
//        if(debit>=money){
            walletService.updateWallet(wallet);
//        }


    }

    @Override
    protected String[] listensTo() {
        return new String[]{
                "com.eking.order.domain.order.event.OrderPriceGeneratedDomainEvent"
        };
    }
}
