package com.mt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Images {

    private Integer imageId;

    private Integer type;

    private Integer channel;

    private String title;

    private String shortTitle;

    private Integer sortOrder;

    private Date publishTime;

    private Integer status;

    private String thumbnail;

    private String remark;
}