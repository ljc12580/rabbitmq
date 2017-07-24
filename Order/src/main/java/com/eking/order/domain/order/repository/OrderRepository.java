package com.eking.order.domain.order.repository;

import com.eking.order.common.persistence.BaseRepository;
import com.eking.order.domain.order.model.Order;

/**
 * Created by 童春 on 2017/7/10.
 */
public interface OrderRepository extends BaseRepository {
    public int GeneratePreOrder(Order order);
    public int FinishOrder(Integer orderid);
    public Order GetPreOrderByID(Integer preOrderID);
}
