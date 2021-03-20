package com.example.mynewblog.bean;

import java.sql.Timestamp;

/**
 * 用户实体
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;                // 角色权限
    private boolean state;              // 启用标识
    private Timestamp createTime;       // 创建时间

    public User() {
    }

    public User(String username, String password, String email, String role, boolean state, Timestamp createTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
