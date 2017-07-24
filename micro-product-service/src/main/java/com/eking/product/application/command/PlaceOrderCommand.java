package com.eking.product.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Jaye on 2017/7/10.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderCommand {

    private String orderId;      //订单id
    private String productId;     //产品id
    private Integer productNumber; //产品数量

}
