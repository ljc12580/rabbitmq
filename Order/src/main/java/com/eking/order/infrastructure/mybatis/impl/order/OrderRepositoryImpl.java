package com.eking.order.infrastructure.mybatis.impl.order;

import com.eking.order.domain.order.model.Order;
import com.eking.order.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 童春 on 2017/7/10.
 */
@Component("OrderRepositoryImpl")
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public Object get(Object entity) {
        return null;
    }

    @Override
    public List findList(Object entity) {
        return null;
    }

    @Override
    public List findAllList(Object entity) {
        return null;
    }

    @Override
    public int insert(Object entity) {
        return 0;
    }

    @Override
    public int update(Object entity) {
        return 0;
    }

    @Override
    public int GeneratePreOrder(Order order) {
        return 1;
    }

    @Override
    public int FinishOrder(Integer orderid) {
        return 1;
    }

    @Override
    public Order GetPreOrderByID(Integer preOrderID) {
        return new Order(
                1,
                5,
                BigDecimal.valueOf(5000),
                0,
                10,
                10
        );
    }
}
