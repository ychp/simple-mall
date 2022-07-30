package com.yingchengpeng.mall.gateway.rpc.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:17 PM
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PlainResult<T> extends BaseResult {

    private static final long serialVersionUID = -8523063973578970137L;

    private T data;

    public PlainResult() {
    }

    public PlainResult(int code, String message) {
        super(code, message);
    }

    public static <T> PlainResult<T> success(T data) {
        PlainResult<T> plainResult = new PlainResult<>();
        plainResult.setData(data);
        return plainResult;
    }

    public static <T> PlainResult<T> fail(int code, String message) {
        return new PlainResult<>(code, message);
    }
}
