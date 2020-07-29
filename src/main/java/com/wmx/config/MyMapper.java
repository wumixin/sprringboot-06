package com.wmx.config;

/**
 * @Author wumixin
 * @date 2020/7/28
 **/

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;

public interface MyMapper<T, PK> extends BaseMapper<T>, IdListMapper<T, PK> {}

