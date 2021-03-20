package com.example.mynewblog.dao;

import com.example.mynewblog.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public User getUserByMessage(@Param("username") String username, @Param("password") String password);

    public int insertUserMessage(@Param("username") String username, @Param("password") String password);
}
