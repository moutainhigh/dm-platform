package com.damon.shared.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 请求验签参数
 * @author Damon S.
 */
@Data
public class SecurityReqDTO {

    @NotNull(message = "验签不能为空")
    @ApiModelProperty(name = "sign", value = "请求验签")
    private String sign;

    @NotNull(message = "nonce不能为空")
    @ApiModelProperty(name = "nonce", value = "时间参数(毫秒)")
    private Long nonce;
}