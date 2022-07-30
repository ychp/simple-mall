package com.yingchengpeng.mall.user.gateway.rpc.dto.request;

import com.yingchengpeng.mall.gateway.rpc.dto.response.BaseResult;
import com.yingchengpeng.mall.gateway.rpc.dto.response.PlainResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author yingchengpeng
 * @date 2022/7/31 12:18 AM
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserRegisterRequest extends BaseResult {

    private static final long serialVersionUID = -5973526862079166978L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    @NotNull(message = "手机号不允许为空")
    private String phone;

    /**
     * 密码
     */
    @NotNull(message = "密码不允许为空")
    private String password;

}
