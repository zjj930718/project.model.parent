package com.info.dao.plugin;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface TkMybatisMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
