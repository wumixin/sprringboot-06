package com.wmx.component;

import com.wmx.utils.JwtUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wmx
 * @daata 2020/7/28
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if(null != token){
            boolean verify = JwtUtil.verify(token);
            if(verify){
                return true;
            }/*else{
                ValueOperations<String, Object> ops = redisTemplate.opsForValue();
                if(ops != null) {
                    User user = null;
                    user = (User) ops.get(token);
                    if (user != null){
                        String newtoken = JwtUtil.sign(user);
                        redisTemplate.opsForValue().set(newtoken,user);
                        return true;
                    }
                }
            }*/
        }
        return false;
    }
}
