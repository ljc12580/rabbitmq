package com.eking.wallet.domain.wallet.service;

import com.eking.wallet.common.model.ResultEntity;
import com.eking.wallet.domain.wallet.model.Wallet;
import com.eking.wallet.domain.wallet.repository.WalletRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;

/**
 * Created by apple on 17/7/11.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletService walletService;

    @Before
    public void InitMockito(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void query_UseridIsNull(){
        String userid=null;
        ResultEntity resultEntity=walletService.queryWallet(userid);
        Assert.assertEquals("用户id不允许为空",resultEntity.DetailedInfo);
        Assert.assertEquals(false,resultEntity.IsSuccess);
    }
    @Test
    public void query_UseridIsNotExist(){
        String userid="{\"userid\":\"1\"}";
        when(walletRepository.query(1)).thenReturn(null);
        ResultEntity resultEntity=walletService.queryWallet(userid);
        Assert.assertEquals(false,resultEntity.IsSuccess);
        Assert.assertEquals("用户id查不到相关记录",resultEntity.DetailedInfo);

    }
    @Test
    public void query_success(){
        String userid="{\"userid\":\"2\"}";
        Wallet wallet=new Wallet();
        wallet.setUserid(2);
        wallet.setMoney(BigDecimal.valueOf(20));
        wallet.setPay_time(new Date().toString());
        when(walletRepository.query(2)).thenReturn(wallet);
        ResultEntity resultEntity=walletService.queryWallet(userid);
        Assert.assertEquals(true,resultEntity.IsSuccess);
        Assert.assertEquals(wallet,resultEntity.t);


    }
    @Test
    public void update_WalletIsNull(){
        Wallet wallet=null;
        boolean  aaa=walletService.updateWallet(wallet);
        Assert.assertEquals(false,aaa);
    }
    @Test
    public void update_DebitIsNotEnough(){
        Wallet wallet=new Wallet();
        wallet.setUserid(3);
        wallet.setMoney(BigDecimal.valueOf(20));
        when(walletRepository.query(3)).thenReturn(wallet);
        Wallet wallet1=new Wallet();
        wallet1.setMoney(BigDecimal.valueOf(30));
        wallet1.setUserid(3);
        Assert.assertEquals(false,walletService.updateWallet(wallet1));
    }
    @Test
    public void update_Debit_Success(){
        Wallet wallet=new Wallet();
        wallet.setUserid(4);
        wallet.setMoney(BigDecimal.valueOf(20));
        when(walletRepository.query(4)).thenReturn(wallet);
        Wallet wallet1=new Wallet();
        wallet1.setMoney(BigDecimal.valueOf(10));
        wallet1.setUserid(4);
        Assert.assertEquals(true,walletService.updateWallet(wallet1));

    }
}
