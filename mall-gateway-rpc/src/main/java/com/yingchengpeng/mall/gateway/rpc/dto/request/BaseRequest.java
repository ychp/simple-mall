package com.yingchengpeng.mall.gateway.rpc.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 导购业绩基础请求类
 *
 * @author yingchengpeng
 * @date 2021-07-12
 */
@Data
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 8822547444664337777L;

    /**
     * 请求来源
     */
    @NotNull(message = "来源不能为空")
    private String source;

    /**
     * 操作人
     */
    @NotNull(message = "操作人不能为空")
    private OperatorDTO operator;

}