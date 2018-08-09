package com.mt.web.view.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
@Data
@ApiModel(value = "需求查询对象")
public class CRQuery {

    @ApiModelProperty(value = "排序条件")
    private String orderBy;
}
