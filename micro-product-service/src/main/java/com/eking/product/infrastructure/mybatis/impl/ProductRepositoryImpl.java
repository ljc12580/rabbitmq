package com.eking.product.infrastructure.mybatis.impl;

import com.eking.product.domain.model.Product;
import com.eking.product.domain.repository.ProductRepository;
import com.eking.product.infrastructure.mybatis.impl.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jaye on 2017/7/10.
 */
@Component("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getProduct(Product product) {
        return productMapper.get(Integer.toString(product.getId()));
    }

    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.update(product);
    }
}
