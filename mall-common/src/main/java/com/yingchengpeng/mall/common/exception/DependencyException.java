package com.yingchengpeng.mall.common.exception;

import com.yingchengpeng.mall.common.exception.code.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * 防腐层异常
 *
 * @author yingchengpeng
 * @date 2022/7/30 11:54 PM
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DependencyException extends BaseException {

    private static final long serialVersionUID = -6475446206267838668L;

    /**
     * RPC接口名称
     */
    public static final String RPC_INTERFACE = "RPC_INTERFACE";

    /**
     * RPC接口功能名称
     */
    public static final String RPC_FUNCTION = "RPC_FUNCTION";

    /**
     * RPC接口返回值
     */
    public static final String RPC_RESULT = "RPC_RESULT";

    /**
     * RPC接口入参
     */
    public static final String RPC_PARAM = "RPC_PARAM";

    public DependencyException(ErrorCode error, Throwable t) {
        super(error, t);
    }

    public DependencyException(ErrorCode error, Map<String, Object> attachments, Throwable t) {
        super(error, attachments, t);
    }
}
