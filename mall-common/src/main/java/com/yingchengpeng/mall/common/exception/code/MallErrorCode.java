package com.yingchengpeng.mall.common.exception.code;

import lombok.Getter;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:50 PM
 */
public enum MallErrorCode implements ErrorCode {
    INNER_SYSTEM_ERROR(500, "服务器异常"),
    PARAMETER_ERROR(400, "参数错误"),
    OTHER_ERROR_CODE(999999999, "系统异常"),
    ;

    @Getter
    private final int code;
    @Getter
    private final String message;

    MallErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
