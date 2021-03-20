package com.example.mynewblog.service;

import com.example.mynewblog.bean.Article;

public interface ArticleService {

    /**
     * 发布文章
     * @return
     */
    public int publishArticle(Article articles);
}
