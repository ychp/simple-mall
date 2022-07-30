package com.yingchengpeng.mall.common.exception;

import com.yingchengpeng.mall.common.exception.code.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:54 PM
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -121902211700546344L;

    private int code;

    private Map<String, Object> attachments;

    public BaseException(ErrorCode error, Throwable t) {
        super(error.getMessage(), t);
        this.code = error.getCode();
    }

    public BaseException(ErrorCode error, Map<String, Object> attachments, Throwable t) {
        super(error.getMessage(), t);
        this.code = error.getCode();
        this.attachments = attachments;
    }
}
