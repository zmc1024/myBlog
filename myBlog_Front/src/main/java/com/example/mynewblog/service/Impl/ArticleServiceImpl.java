package com.example.mynewblog.service.Impl;

import com.example.mynewblog.bean.Article;
import com.example.mynewblog.dao.ArticleDao;
import com.example.mynewblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int publishArticle(Article articles) {
        return articleDao.insertArticleMessage(articles.getUser_id(), articles.getTitle(),
                articles.getCategory_id(), articles.getTag(), articles.getType(),
                articles.getContent(), articles.getContent_format());
    }
}
