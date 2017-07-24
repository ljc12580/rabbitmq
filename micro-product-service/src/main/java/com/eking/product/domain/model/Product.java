package com.eking.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Jaye on 2017/7/10.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String productName;
    private Integer totalNumber;
    private String productDescribe;
    private Integer availableNumber;

    public Product createProduct(Integer id,
                                 String productName,
                                 Integer totalNumber,
                                 String productDescribe,
                                 Integer availableNumber){
        return new Product(id,productName,totalNumber,productDescribe,availableNumber);
    }
}