package com.example.mynewblog.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
    private int id;                     // 主键
    private String user_id;                // 用户id
    private String title;               // 文章标题
    private int category_id;            // 博文分类类别
    private String tag;                 // 博文标签
    private int type;                   // 发布形式
    private String content;             // 文章内容
    private String content_format;      // html的content
    private int read_num;               // 阅读量
    private int comment_num;            // 评论量
    private int like_num;               // 点赞量
    private Timestamp create_time;      // 创建时间
    private Timestamp update_time;      // 更新时间
    private boolean recommend;          // 是否推荐文章
    private boolean publish;            // 发布状态
    private boolean top;                // 是否置顶

    public Article() {
    }

    public Article(String user_id, String title, int category_id, String tag, int type, String content, String content_format, int read_num, int comment_num, int like_num, Timestamp create_time, Timestamp update_time, boolean recommend, boolean publish, boolean top) {
        this.user_id = user_id;
        this.title = title;
        this.category_id = category_id;
        this.tag = tag;
        this.type = type;
        this.content = content;
        this.content_format = content_format;
        this.read_num = read_num;
        this.comment_num = comment_num;
        this.like_num = like_num;
        this.create_time = create_time;
        this.update_time = update_time;
        this.recommend = recommend;
        this.publish = publish;
        this.top = top;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_format() {
        return content_format;
    }

    public void setContent_format(String content_format) {
        this.content_format = content_format;
    }

    public int getRead_num() {
        return read_num;
    }

    public void setRead_num(int read_num) {
        this.read_num = read_num;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", category_id=" + category_id +
                ", tag='" + tag + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", content_format='" + content_format + '\'' +
                ", read_num=" + read_num +
                ", comment_num=" + comment_num +
                ", like_num=" + like_num +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", recommend=" + recommend +
                ", publish=" + publish +
                ", top=" + top +
                '}';
    }
}
