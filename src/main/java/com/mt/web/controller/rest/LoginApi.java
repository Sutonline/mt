package com.mt.web.controller.rest;

import com.mt.common.BizException;
import com.mt.pojo.User;
import com.mt.repository.UserMapper;
import com.mt.web.advice.WrapRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author yongkang.zhang
 * created at 06/08/2018
 */
@RestController
@RequestMapping(value = "/mt")
@Api(value = "登录api")
@WrapRestController
public class LoginApi {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     * @param username 用户名
     * @param password 加密后的密码
     * @return 登录结果
     */
    @PutMapping(value = "/login")
    @ApiOperation(value = "根据用户名和密码进行登录", notes = "密码是加密后的密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "username", value = "密码")
    })
    public Boolean login(@RequestParam String username, @RequestParam String password) {
        if (username == null || password == null) {
            throw new BizException("用户名密码不可为空");
        }

        User user = userMapper.selectByAccount(username);

        if (user == null) {
            throw new BizException("用户不存在!");
        }

        return Objects.equals(user.getPassword(), password);
    }

    @PutMapping(value = "/resetPassword")
    public Boolean resetPassword(@RequestParam String username, @RequestParam String password) {
        if (username == null || password == null) {
            throw new BizException("用户名密码不可为空");
        }

        User user = userMapper.selectByAccount(username);

        if (user == null) {
            throw new BizException("用户不存在!");
        }

        user.setPassword(password);

        return userMapper.updateByPrimaryKey(user) == 1;
    }

    @GetMapping(value = "/getVerifyCode")
    public String getVerifyCode(@RequestParam String username) {
        if (username == null) {
            throw new BizException("必须先填写用户");
        }

        User user = userMapper.selectByAccount(username);

        if (user == null) {
            throw new BizException("用户不存在");
        }

        // todo send message code
        return "12245";
    }


}
