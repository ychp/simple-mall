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
public class PaginatorResult<T> extends BaseResult {

    private static final long serialVersionUID = -8522791347236201938L;

    private List<T> data;

    private Paginator paginator;

    public PaginatorResult() {
    }

    public PaginatorResult(List<T> data, Paginator paginator) {
        this.data = data;
        this.paginator = paginator;
    }

    public PaginatorResult(int code, String message) {
        super(code, message);
    }

    public static <T> PaginatorResult<T> success(List<T> data, Paginator paginator) {
        return new PaginatorResult<>(data, paginator);
    }

    public static <T> PaginatorResult<T> fail(int code, String message) {
        return new PaginatorResult<>(code, message);
    }
}
