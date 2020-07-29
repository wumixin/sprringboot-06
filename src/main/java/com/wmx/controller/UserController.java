package com.wmx.controller;

import com.wmx.mapper.UserMapper;
import com.wmx.pojo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author wumixin
 * @date 2020/7/28
 **/
@Api("用户操作相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @ApiOperation("查询所有用户")
    @GetMapping("/findAll")
    public String findAll() {
        List<User> users = userMapper.selectAll();
        return users.toString();
    }
    @ApiOperation("在 redis中存储用户名和密码")
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        String token = request.getHeader("token");
        User user = null;
        try {
            user = (User) ops.get(token);
            System.out.println("user = " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (user != null) {
                return user.toString();
            }
        }
        return "login first int get user";
    }
}
