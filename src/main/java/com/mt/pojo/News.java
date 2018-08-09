package com.mt.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(value = "动态")
public class News {

    @ApiModelProperty(value = "新闻id")
    private Integer newsId;

    @NotNull(message = "标题不可为空")
    @ApiModelProperty(value = "动态标题", required = true)
    private String title;

    @NotNull(message = "链接不可为空")
    @ApiModelProperty(value = "动态链接", required = true)
    private String link;

    @ApiModelProperty(value = "状态, 暂时无用")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "备注")
    private String remark;
}