package com.mt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class News {

    private Integer newsId;

    private String title;

    private String link;

    private Integer status;

    private Date createTime;

    private Date modifyTime;

    private String remark;
}