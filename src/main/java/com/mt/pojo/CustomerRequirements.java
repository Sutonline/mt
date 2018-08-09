package com.mt.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class CustomerRequirements {

    @ApiModelProperty("需求id，自动生成")
    private Integer reqId;

    @NotNull(message = "姓名不可为空")
    @ApiModelProperty(value = "客户姓名", required = true)
    private String name;

    @NotNull(message = "联系方式不可为空")
    @ApiModelProperty(value = "客户联系方式", required = true)
    private String contactWay;

    @NotNull(message = "项目标题不可为空")
    @ApiModelProperty(value = "项目标题", required = true)
    private String projectTitle;

    @ApiModelProperty(value = "项目详情")
    private String projectDetail;

    @ApiModelProperty(value = "状态, 暂时无用")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

}