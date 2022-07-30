package com.yingchengpeng.mall.common.exception;

import com.yingchengpeng.mall.common.exception.code.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 业务异常
 *
 * @author yingchengpeng
 * @date 2022/7/30 11:54 PM
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends BaseException {

    private static final long serialVersionUID = -6475446206267838668L;

    public BusinessException(ErrorCode error, Throwable t) {
        super(error, t);
    }
}
