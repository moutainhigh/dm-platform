package com.damon.product.domain.sku.event;

import com.damon.product.domain.sku.aggregate.SkuId;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/***
 * SKU单品创建成功
 * @author Damon S.
 */
@Value
@Builder
public class SkuCreatedEvent {
    @TargetAggregateIdentifier
    private final SkuId skuId;
}
