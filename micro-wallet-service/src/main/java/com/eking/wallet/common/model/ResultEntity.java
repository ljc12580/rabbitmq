package com.eking.wallet.common.model;

import java.util.List;

public class ResultEntity<T> {
    public boolean IsSuccess;
    public String ErrorCode;
    public String DetailedInfo;
    public T t;
    public List<T> tList;
}