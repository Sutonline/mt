package com.mt.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String mobile;

    private Date lastLoginTime;

    private String remark;
}