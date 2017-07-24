package com.eking.product.infrastructure.mybatis.impl;

import com.eking.product.domain.model.ProductOrder;
import com.eking.product.domain.repository.ProductOrderRepository;
import com.eking.product.infrastructure.mybatis.impl.dao.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jaye on 2017/7/10.
 */
@Component("productOrderRepository")
public class ProductOrderRepositoryImpl implements ProductOrderRepository {
    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Override
    public int updateProductStateByOrderId(ProductOrder productOrder) {
        return productOrderMapper.update(productOrder);
    }

    @Override
    public int addProductByOrderId(ProductOrder productOrder) {
        return productOrderMapper.insert(productOrder);
    }

    @Override
    public int getLockedProductByOrderId(String orderId, String prductId) {
        return productOrderMapper.getProduct(orderId, prductId);
    }
}
