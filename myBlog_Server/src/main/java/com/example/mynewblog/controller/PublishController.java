package com.example.mynewblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mynewblog.bean.Article;
import com.example.mynewblog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class PublishController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/publish")
    public Map publish(@RequestBody Article articles) {
        HashMap<String,Object> res = new HashMap<>();

        try {
            int sum = articleService.publishArticle(articles);
            if (sum == 1) res.put("message","发布文章成功！");
            log.debug("用户发布文章成功");
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            res.put("message","发布文章失败");
            log.debug("用户发布文章失败");
            return res;
        }
    }
}
