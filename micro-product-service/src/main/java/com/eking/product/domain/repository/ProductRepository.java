package com.eking.product.domain.repository;

import com.eking.product.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jaye on 2017/7/10.
 */
public interface ProductRepository {

    List<Product> getAllProduct(); //获取所有产品

    Product getProduct(Product product); //获取单个产品

    int addProduct(Product product); //添加产品

    int updateProduct(Product product); //更新产品

}
