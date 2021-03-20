package com.example.mynewblog.bean;

import java.io.Serializable;

public class Query extends Article implements Serializable {
    private String category;
    private String tag;
    private String sort;

    public Query() {
    }

    public Query(String category, String tag, String sort) {
        this.category = category;
        this.tag = tag;
        this.sort = sort;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Query{" +
                "category='" + category + '\'' +
                ", tag='" + tag + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
