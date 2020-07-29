package com.wmx.controller;

import com.wmx.mapper.UserMapper;
import com.wmx.pojo.entity.User;
import com.wmx.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wmx
 * @daata 2020/7/28
 */
@RestController
@Api("用户登录相关操作")
public class LoginController {

    @Resource
    UserMapper userMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @ApiOperation("用户登录接口需要进行验证，登录成功返回token")
    @GetMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                String token = JwtUtil.sign(user);
                redisTemplate.opsForValue().set(token,user);
                return token;
            }
        }
        return "NO";
    }

}
