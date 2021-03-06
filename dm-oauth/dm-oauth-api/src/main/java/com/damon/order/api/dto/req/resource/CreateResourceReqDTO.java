package com.damon.order.api.dto.req.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


/**
 * 用户登录请求
 * @author Damon S.
 */
@Data
@ToString
@ApiModel(value = "创建资源所需参数")
public class CreateResourceReqDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(name = "code", value = "资源编码", required = true)
    @NotNull(message = "请输入资源编码")
    @Pattern(regexp = "^\\w{1,15}$", message = "资源编码应为15个以内英文数字组合")
    private String code;


    @ApiModelProperty(name = "name", value = "资源名称", required = true)
    @NotNull(message = "请输入资源名称")
    @Pattern(regexp = "[\\u4e00-\\u9fa5]{1,10}", message = "资源名称应为10个以内汉字")
    private String name;


    @ApiModelProperty(name = "parentId", value = "父资源ID")
    private Long parentId;

}

