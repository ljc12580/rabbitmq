package com.eking.product.application;

import com.eking.product.application.command.PlaceOrderCommand;
import com.eking.product.domain.event.ProductLockedSuccessEvent;
import com.eking.product.domain.repository.ProductOrderRepository;
import com.eking.product.domain.service.EventPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Jaye on 2017/7/10.
 */
@Service
public class ProductApplicationService {

//    @Autowired
//    private ProductOrderRepository productOrderRepository;

    public void lockedProduct(PlaceOrderCommand placeOrderCommand){

    }
}
