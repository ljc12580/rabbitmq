package com.eking.wallet.domain.wallet.model;

import java.math.BigDecimal;

/**
 * Created by apple on 17/7/10.
 */
public class Wallet {
    private int userid;
    private String pay_time;
    private BigDecimal money;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
