package com.example.mynewblog.dao;

import com.example.mynewblog.bean.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryDao {

    // 查询全部
    public List<Article> Query();

    // 按时间倒叙查询全部
    public List<Article> QueryByTimeDesc();

    // 根据文章id查询文章
    public List<Article> QueryById(@Param("id") int id);

    public List<Article> QueryByCategory(@Param("category_id") String category_id);
}
