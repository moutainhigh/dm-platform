package com.damon.order.api.dto.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Damon S.
 */
@ToString
@Data
@NoArgsConstructor
@ApiModel(value = "完善用户详情信息")
public class CompleteUserDetailReqDTO implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户ID", required = true)
    @NotNull(message = "请输入用户ID")
    private Long userId;

    @ApiModelProperty(name = "email", value = "邮箱")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不合法")
    private String email;

    @ApiModelProperty(name = "phone", value = "手机号", required = true)
    @Pattern(regexp = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$", message = "手机号码不合法")
    private String phone;

    @ApiModelProperty(name = "qq", value = "QQ")
    @Pattern(regexp = "[1-9][0-9]{4,}", message = "QQ号码不合法")
    private Long qq;

    @ApiModelProperty(name = "contact", value = "联系地址")
    private String contact;
}
