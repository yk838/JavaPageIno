package com.yk.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.mapper.UserMapper;
import com.yk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Map<String, Object>> queryUserList(HashMap<Object, Object> parMap) {
        int pageNo = (int) parMap.get("pageNo");//当前页
        int pageSize = (int) parMap.get("pageSize");//每页条数

        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, Object>> queryUserList = userMapper.queryUserList(parMap);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(queryUserList);
        return pageInfo;
    }
}
