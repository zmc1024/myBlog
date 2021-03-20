package com.example.mynewblog.service;

import com.example.mynewblog.bean.Article;
import com.example.mynewblog.bean.Query;

import java.util.List;

public interface QueryService {

    /**
     * 根据 Category 查找文章
     * @param query
     * @return
     */
    public List<Article> QueryByCategory(Query query);

    /**
     * 根据 Category 和 sort 查找文章
     * @param query
     * @return
     */
    public List<Article> QueryByCS(Query query);

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    public List<Article> QueryById(int id);
}
