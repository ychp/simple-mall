package com.yingchengpeng.mall.common.exception.code;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:50 PM
 */
public interface ErrorCode {
    /**
     * 错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 错误文案
     *
     * @return 错误文案
     */
    String getMessage();
}
