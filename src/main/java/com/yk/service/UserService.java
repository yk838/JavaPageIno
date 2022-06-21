package com.yk.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    PageInfo<Map<String, Object>> queryUserList(HashMap<Object, Object> parMap);
}
