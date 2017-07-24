package com.eking.wallet.domain.wallet.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eking.wallet.application.EventPublish;
import com.eking.wallet.common.model.ResultEntity;
import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by apple on 17/7/10.
 */
@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private EventPublish eventPublish;

    public ResultEntity queryWallet(String userid){
        ResultEntity resultEntity=new ResultEntity();
        Wallet wallet=new Wallet();
        if(userid==null){
            resultEntity.IsSuccess=false;
            resultEntity.DetailedInfo="用户id不允许为空";
            return  resultEntity;
        }
        JSONObject jsonObject=JSON.parseObject(userid);
        int userid1=jsonObject.getInteger("userid");
        wallet=walletRepository.query(userid1);
        if(userid1==0){
            resultEntity.IsSuccess=false;
            resultEntity.DetailedInfo="用户id不允许为0";
            return  resultEntity;
        }
        if(wallet==null){
            resultEntity.IsSuccess=false;
            resultEntity.DetailedInfo="用户id查不到相关记录";
            return resultEntity;
        }else {
            wallet = walletRepository.query(userid1);
            resultEntity.IsSuccess = true;
            resultEntity.t = wallet;
//            WalletPaySuccessEvent walletPaySuccessEvent = new
//                    WalletPaySuccessEvent(10, 20, new Date());
//
//
////            EventPublish eventPublish = new EventPublish();
//            eventPublish.publish(walletPaySuccessEvent);
            return resultEntity;

        }
    }

    public boolean updateWallet(Wallet wallet){
        //获取传入消费金额与用户id
        if(wallet==null){
            return false;
        }
        BigDecimal money=wallet.getMoney();
        int userid=wallet.getUserid();
        //获取用户实际余额
        Wallet wallet1=walletRepository.query(userid);
        BigDecimal debit=wallet1.getMoney();
        if(debit.compareTo(money)>0){
            wallet1.setMoney(debit.subtract(money));
            wallet1.setPay_time(new Date().toString());
            walletRepository.update(wallet1);
//            WalletPaySuccessEvent walletPaySuccessEvent = new
//                    WalletPaySuccessEvent(10, 20, new Date());
//
//
////            EventPublish eventPublish = new EventPublish();
//            eventPublish.publish(walletPaySuccessEvent);
            return true;
        }

//        wallet.setMoney(debit-money);
//        Date date=new Date();
//        wallet.setPay_time(date.toString());
//        walletRepository.update(wallet);
        return false;
    }
}
