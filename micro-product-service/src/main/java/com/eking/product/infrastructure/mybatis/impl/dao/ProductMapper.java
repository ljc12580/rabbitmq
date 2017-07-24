package com.eking.product.infrastructure.mybatis.impl.dao;

import com.eking.product.domain.model.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jaye on 2017/7/10.
 */
@Mapper
public interface ProductMapper {
    Product get(String id);
    int insert(Product product);
    int update(Product product);
}
