package com.wmx.mapper;

import com.wmx.config.MyMapper;
import com.wmx.pojo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author wumixin
 * @date 2020/7/28
 **/
@Mapper
public interface BookMapper extends MyMapper<Book, Integer> {
}
