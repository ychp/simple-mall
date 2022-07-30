package com.yingchengpeng.mall.gateway.rpc.dto.request;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yingchengpeng
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BasePageRequest extends BaseRequest {
    private static final long serialVersionUID = 5047404527053130836L;

    /**
     * 默认页码
     */
    private static final int DEFAULT_PAGE = 1;

    /**
     * 默认分页大小
     */
    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 查询页码
     */
    @Setter
    protected Integer page;

    /**
     * 查询分页大小
     */
    @Setter
    protected Integer pageSize;

    public Integer getPage() {
        return page == null ? DEFAULT_PAGE : page;
    }

    public Integer getPageSize() {
        return pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }

    /**
     * 计算数据库offset
     */
    public int offset() {
        return (page - 1) * pageSize;
    }
}
