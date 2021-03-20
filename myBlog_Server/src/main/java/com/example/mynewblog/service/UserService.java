package com.example.mynewblog.service;

import com.example.mynewblog.bean.User;

public interface UserService {
    /**
     * 根据用户名密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User queryUserInfoByMessage(String username, String password);

    /**
     * 插入用户数据
     * @param username
     * @param password
     * @return
     */
    public int insertUserInfo(String username, String password);
}
