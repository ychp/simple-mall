package com.yingchengpeng.mall.user.gateway.rpc.service.impl;

import com.yingchengpeng.mall.gateway.rpc.dto.response.PlainResult;
import com.yingchengpeng.mall.user.gateway.rpc.dto.request.UserRegisterRequest;
import com.yingchengpeng.mall.user.gateway.rpc.service.UserRegisterGateway;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author yingchengpeng
 * @date 2022/7/31 12:24 AM
 */
@DubboService(validation = "true")
public class UserRegisterGatewayImpl implements UserRegisterGateway {

    @Override
    public PlainResult<String> register(UserRegisterRequest request) {
        return PlainResult.success(null);
    }
}
