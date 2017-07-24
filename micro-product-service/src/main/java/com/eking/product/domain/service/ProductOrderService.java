package com.eking.product.domain.service;

import com.eking.product.domain.event.ProductLockedSuccessEvent;
import com.eking.product.domain.model.Product;
import com.eking.product.domain.model.ProductOrder;
import com.eking.product.domain.repository.ProductOrderRepository;
import com.eking.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Jaye on 2017/7/10.
 */
@Service
public class ProductOrderService {

//    public boolean availableNumber

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EventPublish eventPublish;

    public boolean lockedProduct(ProductOrder productOrder) {
        if (productOrder != null) {
            //校验幂等性，判断是否已经有对应数据
            Product product = new Product();
            product.setId(Integer.valueOf(productOrder.getProductId()));
            product.setAvailableNumber(productOrder.getProductNumber());
            //可用数
//            Product availableNumber = productRepository.getProduct(product);
            if (productOrderRepository.getLockedProductByOrderId(productOrder.getOrderId(), productOrder.getProductId()) > 0) {
                return false;
            } else if (productRepository.getProduct(product).getAvailableNumber()<productOrder.getProductNumber()) {
//                      < productOrder.getProductNumber();
                //校验库存大于订单产品数
                return false;
            } else {
                productRepository.updateProduct(product);
                productOrderRepository.addProductByOrderId(productOrder);
                return true;

            }
        }
        return false;
    }

    public void publihSuccessEvent(Integer ordId) {
        ProductLockedSuccessEvent productLockedSuccessEvent = new
                ProductLockedSuccessEvent(ordId,
                new Date(),
                1);
        eventPublish.publish(productLockedSuccessEvent);
    }

    public boolean updateProductOrder(ProductOrder productOrder){
        if (productOrderRepository.updateProductStateByOrderId(productOrder)>0){
            return true;
        }
        return false;
    }
}
