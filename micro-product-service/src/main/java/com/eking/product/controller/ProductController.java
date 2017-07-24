package com.eking.product.controller;

import com.eking.product.application.ProductApplicationService;
import com.eking.product.application.command.PlaceOrderCommand;
import com.eking.product.domain.model.Product;
import com.eking.product.domain.repository.ProductRepository;
import com.eking.product.domain.service.ProductOrderService;
import com.eking.product.infrastructure.mybatis.impl.dao.ProductMapper;
import com.eking.product.infrastructure.mybatis.impl.dao.ProductOrderMapper;
import com.eking.product.port.PlaceOrderListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Jaye on 2017/7/10.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductApplicationService productApplicationService;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/success")
    public String productLockedSuccess(){
        PlaceOrderCommand placeOrderCommand = new
                PlaceOrderCommand("001",
                "002",
                100);
        productApplicationService.lockedProduct(placeOrderCommand);
        return null;
    }
    @RequestMapping("/getnum")
    public String getProductNum(){
        Product product=new Product();
        product.setId(10);
        Product availableNumber = productRepository.getProduct(product);
        int a=10;
        return null;
    }
}
