package com.example.mynewblog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao {

    public int insertArticleMessage(@Param("user_id") String user_id, @Param("title")String title,
                                    @Param("category_id")int category_id, @Param("tag")String tag,
                                    @Param("type")int type, @Param("content")String content,
                                    @Param("content_format")String content_format);
}
