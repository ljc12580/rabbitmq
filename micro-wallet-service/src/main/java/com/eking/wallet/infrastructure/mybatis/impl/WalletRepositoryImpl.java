package com.eking.wallet.infrastructure.mybatis.impl;

import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.repository.WalletRepository;
import com.eking.wallet.infrastructure.mybatis.impl.Wallet.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 17/7/10.
 */
@Component("WalletRepository")
public class WalletRepositoryImpl implements WalletRepository{

    @Autowired
    WalletMapper walletMapper;

    @Override
    public Wallet query(int userid) {
        return walletMapper.query(userid);
    }

    @Override
    public void update(Wallet wallet) {
    }
}
