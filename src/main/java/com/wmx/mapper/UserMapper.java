package com.wmx.mapper;

import com.wmx.config.MyMapper;
import com.wmx.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User,Integer> {
}