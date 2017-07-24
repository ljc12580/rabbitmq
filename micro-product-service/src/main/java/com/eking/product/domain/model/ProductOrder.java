package com.eking.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Jaye on 2017/7/10.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {

    private Integer id;
    private String orderId;      //订单id
    private String productId;     //产品id
    private Integer productNumber; //产品数量
    private String productState; //订单状态
}
