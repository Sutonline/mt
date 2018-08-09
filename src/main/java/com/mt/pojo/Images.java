package com.mt.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(value = "图片对象")
public class Images {

    @ApiModelProperty(value = "图片id, 自动生成的id")
    private Integer imageId;

    @NotNull(message = "类型不可为空")
    @ApiModelProperty(value = "图片类型, 包括案例和纯图片", required = true)
    private Integer type;

    @NotNull(message = "所用频道不可为空")
    @ApiModelProperty(value = "频道", required = true)
    private Integer channel;

    @NotNull(message = "标题不可为空")
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    @NotNull(message = "简略标题不可为空")
    @ApiModelProperty(value = "简略标题", required = true)
    private String shortTitle;

    @ApiModelProperty(value = "排序值")
    private Integer sortOrder;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "状态, 暂时没用")
    private Integer status;

    @NotNull(message = "缩略图不可为空")
    @ApiModelProperty(value = "缩略图", required = true)
    private String thumbnail;

    @ApiModelProperty(value = "备注")
    private String remark;
}