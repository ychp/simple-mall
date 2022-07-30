package com.yingchengpeng.mall.gateway.rpc.dto.response;

import com.yingchengpeng.mall.gateway.rpc.dto.enums.CommonBaseResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yingchengpeng
 * @date 2022/7/30 11:17 PM
 */
@Data
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 6513836581118432295L;

    private boolean success;

    private int code;

    private String message;

    public BaseResult() {
        this.success = true;
        this.code = CommonBaseResultCodeEnum.SUCCESS.code;
        this.message = CommonBaseResultCodeEnum.SUCCESS.message;
    }

    public BaseResult(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }
}
