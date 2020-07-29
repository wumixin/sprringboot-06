package com.wmx.controller;

import com.wmx.mapper.BookMapper;
import com.wmx.pojo.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wumixin
 * @date 2020/7/28
 **/
@RestController
@RequestMapping("/book")
@Api("图书操作相关接口")
public class BookController {

    @Resource
    BookMapper bookMapper;

    @ApiOperation("查询素所有图书")
    @GetMapping("/findAll")
    @CachePut(cacheNames = "c2")
    public List<Book> findAll(){
        List<Book> books = bookMapper.selectAll();
        return books;
    }

    @ApiOperation("根据ID查询图书")
    @GetMapping("/findOne")
    public Book findOne(@RequestParam int id){
        Book book = bookMapper.selectByPrimaryKey(id);
        return book;
    }
}
