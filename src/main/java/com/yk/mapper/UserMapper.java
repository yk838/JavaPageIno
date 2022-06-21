package com.yk.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<Map<String,Object>> queryUserList(HashMap<Object, Object> parMap);
}
