package com.yingchengpeng.mall.gateway.rpc.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:17 PM
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListResult<T> extends BaseResult {

    private static final long serialVersionUID = -3832873196850774628L;

    private List<T> data;

    public ListResult() {
    }

    public ListResult(List<T> data) {
        this.data = data;
    }

    public ListResult(int code, String message) {
        super(code, message);
    }

    public static <T> ListResult<T> success(List<T> data) {
        return new ListResult<>(data);
    }

    public static <T> ListResult<T> fail(int code, String message) {
        return new ListResult<>(code, message);
    }
}
