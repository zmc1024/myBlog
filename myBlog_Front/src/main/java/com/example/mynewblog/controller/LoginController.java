package com.example.mynewblog.controller;

import com.alibaba.fastjson.JSON;
import com.example.mynewblog.bean.User;
import com.example.mynewblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Map login(@RequestBody User user) {
        int flag = 100;
        HashMap<String, Object> res = new HashMap<>();

        try {
            User us = userService.queryUserInfoByMessage(user.getUsername(), user.getPassword());
            if (us != null) {
                flag = 200;
            }
            res.put("flag", flag);
            res.put("user", us);
            log.debug("用户数据查询成功");
            // String res_json = JSON.toJSONString(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.put("flag", flag);
            log.debug("用户数据查询失败");
            return res;
        }
    }

    @RequestMapping("/register")
    public Map register(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();

        try {
            int sum = userService.insertUserInfo(user.getUsername(), user.getPassword());
            if (sum == 1) map.put("message","用户注册成功！");
            log.debug("用户数据插入成功");
            return map;
        }catch (Exception e) {
            e.printStackTrace();
            map.put("message","用户注册失败");
            log.debug("用户数据插入失败");
            return map;
        }
    }
}
