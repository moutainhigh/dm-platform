package com.damon.order.api.dto.req.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * 确认订单请求
 * @author Damon S.
 */
@Data
@ToString
@ApiModel(value = "确认订单参数")
public final class ConfirmOrderReqDTO implements Serializable {
    private static final Long serialVersionUID = 12L;

    @ApiModelProperty(name = "cartItems", value = "购物车下单")
    private List<String> cartItems;


    @NotNull(message = "sku不能为空")
    @ApiModelProperty(name = "sku", value = "sku", required = true)
    private String sku;

    @Pattern(regexp = "^[1-9]\\d*$", message = "数量不能小于1")
    @ApiModelProperty(name = "quantity", value = "购买数量", required = true)
    @Min(1)
    private Integer qty;

    @ApiModelProperty(name = "promotionId", value = "活动编号")
    private String pid;

    @ApiModelProperty(name = "detailId", value = "活动详情编号")
    private String did;
}
