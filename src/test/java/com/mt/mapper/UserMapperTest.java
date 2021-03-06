package com.mt.mapper;

import com.mt.ManApplication;
import com.mt.helper.PasswordHelper;
import com.mt.pojo.User;
import com.mt.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongkang.zhang
 * created at 04/08/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManApplication.class)
@Slf4j
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setAccount("admin");
        String passoword = PasswordHelper.encrypt("admin");
        user.setPassword(passoword);
        user.setEmail("yongkangchn@126.com");
        user.setMobile("13121269980");
        user.setName("管理员");
        user.setRemark("");
        userMapper.insert(user);
    }

    @Test
    public void delete() {
        userMapper.deleteByPrimaryKey(3);
        insert();
    }

    @Test
    public void select() {
        List<User> users = userMapper.selectAll();
        System.out.println(users.get(0));
        userMapper.deleteByPrimaryKey(users.get(0).getId());
        insert();
    }
}
