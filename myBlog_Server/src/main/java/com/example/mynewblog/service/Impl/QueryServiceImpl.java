package com.example.mynewblog.service.Impl;

import com.example.mynewblog.bean.Article;
import com.example.mynewblog.bean.Query;
import com.example.mynewblog.dao.QueryDao;
import com.example.mynewblog.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDao queryDao;

    @Override
    public List<Article> QueryByCategory(Query query) {
        switch (query.getCategory()) {
            case "/":
                return queryDao.Query();
        }
        return null;
    }

    @Override
    public List<Article> QueryByCS(Query query) {

        if (query.getSort().equals("newest")) {      // 按时间倒序查找
            switch (query.getCategory()) {
                case "/":
                    return queryDao.QueryByTimeDesc();
            }
        } else if (query.getSort().equals("hot")) {  //  按时间正序查找
            switch (query.getCategory()) {
                case "/":
                    return queryDao.Query();
            }
        }
        return null;
    }

    @Override
    public List<Article> QueryById(int id) {
        return queryDao.QueryById(id);
    }
}
