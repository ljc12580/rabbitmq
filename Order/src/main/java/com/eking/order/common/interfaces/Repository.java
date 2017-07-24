package com.eking.order.common.interfaces;

/**
 * Created by apple on 17/7/4.
 */
public interface Repository<T> {
    void add(T t);
    void update(T t);
    void delete(T t);
    T queryById(int id);
}
