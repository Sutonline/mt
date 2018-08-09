package com.mt.web.advice;

import com.mt.common.BizException;
import com.mt.web.view.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;


/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
@org.springframework.web.bind.annotation.RestControllerAdvice
@Slf4j
public class RestControllerAdvice implements ResponseBodyAdvice {

    private static final Integer SUCCESS = 1;
    private static final Integer ERROR = 0;

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        return new Result<>(SUCCESS, "操作成功", o);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        Class<? extends Method> clazz = methodParameter.getMethod().getClass();
        return clazz.isAnnotationPresent(WrapRestController.class);
    }

    @ExceptionHandler(BizException.class)
    public Result bizException(BizException e) {
        log.error("system exception", e);
        return new Result<>(ERROR, e.getMessage(), null);
    }

    // todo 区分出来验证异常,对其做特殊处理
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        log.error("system exception", e);
        return new Result<>(ERROR, "操作失败, 请联系系统管理员", null);
    }

}
