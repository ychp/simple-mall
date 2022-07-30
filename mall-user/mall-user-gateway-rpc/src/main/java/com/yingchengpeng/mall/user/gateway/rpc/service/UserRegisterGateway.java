package com.yingchengpeng.mall.user.gateway.rpc.service;

import com.yingchengpeng.mall.gateway.rpc.dto.response.PlainResult;
import com.yingchengpeng.mall.user.gateway.rpc.dto.request.UserRegisterRequest;

/**
 * @author yingchengpeng
 * @date 2022/7/31 12:18 AM
 */
public interface UserRegisterGateway {

    /**
     * 注册
     *
     * @param request 请求参数
     * @return 用户编号
     */
    PlainResult<String> register(UserRegisterRequest request);
}
