package com.mt.web.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T object;

}
