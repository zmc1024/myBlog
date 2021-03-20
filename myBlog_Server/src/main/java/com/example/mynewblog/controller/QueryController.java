package com.example.mynewblog.controller;

import com.example.mynewblog.bean.Article;
import com.example.mynewblog.bean.Query;
import com.example.mynewblog.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    /**
     * 根据 Category 加载 (推荐，后端，前端...)
     * @param query
     * @return
     */
    @RequestMapping("/queryByCategory")
    public List<Article> QueryByCategory(@RequestBody Query query) {
        List<Article> articleList = null;

        try {
            articleList = queryService.QueryByCategory(query);
            if (articleList !=  null) {
                log.debug("文章查询成功");
            }
            return articleList;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("文章查询失败");
            return articleList;
        }
    }


    /**
     * 根据 Category 和 sort 加载 (推荐 + 最新...)
     * @param query
     * @return
     */
    @RequestMapping("/queryByCS")
    public List<Article> QueryByCS(@RequestBody Query query) {
        List<Article> articleList = null;
        try {
            articleList = queryService.QueryByCS(query);
            if (articleList !=  null) {
                log.debug("文章查询成功");
            }
            return articleList;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("文章查询失败");
            return articleList;
        }
    }


    /**
     * 根据 文章id 查询文章
     * @param query
     * @return
     */
    @RequestMapping("/queryById")
    public List<Article> QueryById(@RequestBody Query query) {
        List<Article> articleList = null;

        try {
            articleList = queryService.QueryById(query.getId());
            if (articleList != null) {
                log.debug("根据id查询文章成功");
                return articleList;
            }
            return articleList;
        }catch (Exception e) {
            e.printStackTrace();
            log.debug("根据id查询文章失败");
            return articleList;
        }
    }


    /**
     * 按 Category 和 tag 加载 (后端 + java...，前端 + vue...)
     * @param Category
     * @param tag
     * @return
     */
    @RequestMapping("/queryByCT")
    public Map QueryByCT(int Category, String tag) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }


    /**
     * 按 Category、tag、sort 加载 (后端 + java + 最新...)
     * @param Category
     * @param tag
     * @param sort
     * @return
     */
    @RequestMapping("/queryByCTS")
    public Map QueryByCTS(int Category, String tag, String sort) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }
}
