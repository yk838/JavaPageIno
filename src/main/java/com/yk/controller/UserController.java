package com.yk.controller;

import com.github.pagehelper.PageInfo;
import com.yk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Student")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin //解决跨域
    @RequestMapping("/queryUserList")
    public HashMap<Object, Object> queryUserList(HttpServletRequest request, HttpServletResponse response,
                                                 @RequestParam(value = "pageNo", defaultValue = "2") int pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = "3") int pageSize){
        HashMap<Object, Object> parMap = new HashMap<>();
        HashMap<Object, Object> resMap = new HashMap<>();

        try{
            String id = request.getParameter("id");
            String name = request.getParameter("name");

            parMap.put("id",id);
            parMap.put("name", name);
            parMap.put("pageNo",pageNo);
            parMap.put("pageSize", pageSize);
            PageInfo<Map<String, Object>> queryUserList = userService.queryUserList(parMap);

            resMap.put("success",true);
            resMap.put("date",queryUserList);
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("success",false);
            resMap.put("msg","未知错误");
            resMap.put("e",e);
        }
        return resMap;
    }
}
