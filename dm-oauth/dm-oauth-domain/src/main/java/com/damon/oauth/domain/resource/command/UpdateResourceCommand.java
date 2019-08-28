package com.damon.oauth.domain.resource.command;

import lombok.Builder;
import lombok.Value;

/**
 * 更新资源信息
 * @author Damon S.
 * @version v1.0.1
 * @date 2019年04月19日 13:55
 */
@Value
@Builder
public class UpdateResourceCommand {
    private final Long          resourceId;
    private final String        name;
    private final String        path;
    private final Integer       sort;
    private final String        platform;
    private final Long          updatedBy;
}
