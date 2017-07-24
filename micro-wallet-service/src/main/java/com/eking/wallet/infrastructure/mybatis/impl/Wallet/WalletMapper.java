package com.eking.wallet.infrastructure.mybatis.impl.Wallet;

import com.eking.wallet.domain.wallet.model.Wallet;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by apple on 17/7/10.
 */
@Mapper
public interface WalletMapper {
    public Wallet query(int userid);
    public void update(Wallet wallet);
}
