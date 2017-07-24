package com.eking.wallet.controller;

import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by apple on 17/7/11.
 */
@RestController
public class ControllerTest {
    @Autowired
    WalletService walletService;

    @RequestMapping("/wallet")
    public void test(){
        Wallet wallet=new Wallet();
        wallet.setUserid(10);
        BigDecimal a=new BigDecimal(100);
        wallet.setMoney(a);
        walletService.updateWallet(wallet);

    }
}
