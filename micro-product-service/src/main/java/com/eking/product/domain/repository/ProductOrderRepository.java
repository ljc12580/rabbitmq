package com.eking.product.domain.repository;

import com.eking.product.domain.model.ProductOrder;
import org.springframework.stereotype.Component;

/**
 * Created by Jaye on 2017/7/10.
 */
public interface ProductOrderRepository {
    int updateProductStateByOrderId(ProductOrder productOrder); //根据订单id修改产品状态
    int addProductByOrderId(ProductOrder productOrder); //根据订单添加产品
    int getLockedProductByOrderId(String orderId,String prductId);     // 保证幂等性
}
