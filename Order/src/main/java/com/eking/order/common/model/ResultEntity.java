package com.eking.order.common.model;

public class ResultEntity<T> {
    public boolean IsSuccess;
    public String ErrorCode;
    public String DetailedInfo;
    public T t;
}