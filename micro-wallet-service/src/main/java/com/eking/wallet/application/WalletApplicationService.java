package com.eking.wallet.application;

import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by apple on 17/7/11.
 */
@Service
public class WalletApplicationService {
    @Autowired
    WalletRepository walletRepository;

    public boolean PayOrder(Wallet wallet){
        if(wallet==null){
            return false;
        }
//        Wallet wallet1=new Wallet();
        int userid=wallet.getUserid();
        BigDecimal money=walletRepository.query(userid).getMoney();

    return  false;
    }
}
