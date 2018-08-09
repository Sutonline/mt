package com.mt.common;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
public class BizException extends RuntimeException {

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
