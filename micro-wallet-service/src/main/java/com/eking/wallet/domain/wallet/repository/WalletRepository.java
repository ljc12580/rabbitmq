package com.eking.wallet.domain.wallet.repository;

import com.eking.wallet.domain.wallet.model.Wallet;
import org.springframework.stereotype.Component;

/**
 * Created by apple on 17/7/10.
 */
@Component
public interface WalletRepository{
    Wallet query(int userid);
    void update(Wallet wallet);
}
