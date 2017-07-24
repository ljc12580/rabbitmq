package com.eking.wallet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eking.wallet.common.model.ResultEntity;
import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by apple on 17/7/10.
 */
@RequestMapping(value = "/debit")
@RestController
public class WalletController {


    @Autowired
    WalletService walletService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity queryDebit(@RequestBody String userid){
        ResultEntity resultEntity=walletService.queryWallet(userid);
        return resultEntity;

    }

    @RequestMapping(value = "/update",method =RequestMethod.POST)
    @ResponseBody
    public boolean updateDebit(@RequestBody String wallet){
        JSONObject jsonObject=JSON.parseObject(wallet);
        int userid=jsonObject.getInteger("userid");
        BigDecimal money=jsonObject.getBigDecimal("money");
//        Wallet wallet1=walletService.queryWallet(userid);
//        double debit=wallet1.getMoney();
//            wallet1.setMoney(debit-money);
        Wallet wallet1=new Wallet();
        wallet1.setUserid(userid);
        wallet1.setMoney(money);
            walletService.updateWallet(wallet1);
            return true;

    }
}
