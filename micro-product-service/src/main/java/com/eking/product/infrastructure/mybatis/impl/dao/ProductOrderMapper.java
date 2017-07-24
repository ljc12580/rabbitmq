package com.eking.product.infrastructure.mybatis.impl.dao;

import com.eking.product.domain.model.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jaye on 2017/7/10.
 */
@Mapper
public interface ProductOrderMapper {
    int getProduct(String orderId,String productId);
    int update(ProductOrder productOrder);
    int insert(ProductOrder productOrder);
}
