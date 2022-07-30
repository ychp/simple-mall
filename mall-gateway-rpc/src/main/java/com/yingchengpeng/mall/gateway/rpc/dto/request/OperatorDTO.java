package com.yingchengpeng.mall.gateway.rpc.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 操作人信息
 *
 * @author yingchengpeng
 * @date 2021-07-19
 */
@Data
public class OperatorDTO implements Serializable {

    private static final long serialVersionUID = -7566252493033396467L;

    /**
     * 操作人ID
     */
    private Long id;

    /**
     * 操作人当前店铺
     * 方便越权校验
     */
    private Long shopId;

    /**
     * 操作人姓名
     */
    private String name;

    /**
     * 操作人手机号
     */
    private String phone;
}
