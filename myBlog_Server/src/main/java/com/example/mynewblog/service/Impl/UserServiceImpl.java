package com.example.mynewblog.service.Impl;

import com.example.mynewblog.bean.User;
import com.example.mynewblog.dao.UserDao;
import com.example.mynewblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserInfoByMessage(String username, String password) {
        return userDao.getUserByMessage(username, password);
    }

    @Override
    public int insertUserInfo(String username, String password) {
        return userDao.insertUserMessage(username, password);
    }
}
