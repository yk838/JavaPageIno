package com.yk;

import com.yk.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JavaApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() {
        HashMap<Object, Object> parMap = new HashMap<>();
        List<Map<String, Object>> queryUserList = userMapper.queryUserList(parMap);
        queryUserList.forEach(System.out::println);
    }

}
