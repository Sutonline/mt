package com.mt.web.view.dto;

import com.mt.pojo.Images;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author yongkang.zhang
 * created at 07/08/2018
 */
@Data
@ApiModel(value = "图片保存对象, 包括图像实体和子图片的地址列表")
public class ImageSaveDto {

    @NotNull(message = "父图片对象不可为空")
    @ApiModelProperty(value = "父图片对象", required = true)
    private Images images;

    @Size(min = 1, max = 300, message = "图片数量不合法")
    @ApiModelProperty(value = "子图片地址列表", required = true)
    private List<String> childImagePaths;
}
