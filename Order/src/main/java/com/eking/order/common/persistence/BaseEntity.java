package com.eking.order.common.persistence;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Jaye on 2017/7/4.
 */
@Setter
@Getter
public abstract class BaseEntity <T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
}
