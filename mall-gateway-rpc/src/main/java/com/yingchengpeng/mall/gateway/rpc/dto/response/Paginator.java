package com.yingchengpeng.mall.gateway.rpc.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:17 PM
 */
@Data
public class Paginator implements Serializable {

    private static final long serialVersionUID = 7342390026603902750L;

    private int page;

    private int pageSize;

    private int total;

    public Paginator() {
    }

    public Paginator(int page, int pageSize, int total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }
}
