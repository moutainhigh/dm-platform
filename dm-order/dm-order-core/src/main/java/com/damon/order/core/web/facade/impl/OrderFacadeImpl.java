package com.damon.order.core.web.facade.impl;

import com.damon.oauth.domain.user.aggregate.*;
import com.damon.order.api.dto.req.trade.ConfirmOrderReqDTO;
import com.damon.order.api.dto.req.trade.SubmitOrderReqDTO;
import com.damon.order.api.dto.resp.trade.ConfirmOrderRespDTO;
import com.damon.order.api.dto.resp.trade.SubmitOrderRespDTO;
import com.damon.order.api.web.facade.OrderFacade;
import com.damon.order.domain.trade.aggregate.TradeId;
import com.damon.order.domain.trade.command.ConfirmOrderCommand;
import com.damon.order.domain.trade.command.SubmitOrderCommand;
import com.damon.shared.validation.ArgsValid;
import com.damon.shared.wrapper.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * 订单管理接口
 * @author Damon S.
 */
@Api(tags = "订单管理接口")
@RestController
public class OrderFacadeImpl implements OrderFacade {

    @ArgsValid @Override
    @ApiOperation(value = "确认订单", notes = "确认订单参数")
    public ResponseWrapper<ConfirmOrderRespDTO> confirm(
            ConfirmOrderReqDTO confirmOrderReqDTO) {
        ConfirmOrderCommand command = ConfirmOrderCommand.builder()
                .build();

        ConfirmOrderRespDTO confirmOrderRespDTO = ConfirmOrderRespDTO.builder()
                .build();
        return new ResponseWrapper<>(confirmOrderRespDTO);
    }

    @ArgsValid @Override
    @ApiOperation(value = "提交订单", notes = "提交商品购买订单")
    public ResponseWrapper<SubmitOrderRespDTO> submit(
            SubmitOrderReqDTO submitOrderReqDTO) {
        Long currentUserId = 0L;
        SubmitOrderCommand command = SubmitOrderCommand.builder()
                .tradeId(new TradeId())
                .addressId(new AddressId(submitOrderReqDTO.getAddressId()))
                .message(submitOrderReqDTO.getMessage())
                .couponIds(
                        submitOrderReqDTO.getCouponIds().stream()
                                .map(cid -> new CouponId(Long.valueOf(cid)))
                                .collect(Collectors.toList())
                )
                .invoiceType(submitOrderReqDTO.getInvoiceType())
                .invoiceId(new InvoiceId(submitOrderReqDTO.getInvoiceId()))
                .point(submitOrderReqDTO.getPoint())
                .commission(submitOrderReqDTO.getCommission())
                .skus(
                        submitOrderReqDTO.getSkus().stream()
                                .map(sku -> OrderSku.builder().build())
                                .collect(Collectors.toList())
                )
                .payChannel(submitOrderReqDTO.getPayChannel())
                .createdBy(new UserId(currentUserId))
                .build();

        SubmitOrderRespDTO submitOrderRespDTO = SubmitOrderRespDTO.builder()
                .build();

        return new ResponseWrapper<>(submitOrderRespDTO);
    }
}
