package com.eking.product.domain.event;

import com.eking.micro.common.domain.model.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 产品锁定成功事件
 * Created by Jaye on 2017/7/11.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLockedSuccessEvent implements DomainEvent {


    private Integer orderID;
    private Date occurredOn;
    private int eventVersion;

    @Override
    public int eventVersion() {
        return 1;
    }

    @Override
    public Date occurredOn() {
        return new Date();
    }
}
