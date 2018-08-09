package com.mt.web.view.dto;

import com.mt.pojo.ChildImages;
import com.mt.pojo.Images;
import lombok.Data;

import java.util.List;

/**
 * @author yongkang.zhang
 * created at 07/08/2018
 */
@Data
public class ImagesDetailVO {

    private Images images;

    private List<ChildImages> childImages;
}
