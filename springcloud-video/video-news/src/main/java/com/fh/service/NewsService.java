package com.fh.service;

import com.fh.entity.NewsInfo;

import java.util.List;
import java.util.Map;

public interface NewsService {
    Integer queryCount(NewsInfo news);

    List<Map<String, Object>> queryNewsList(NewsInfo news);

    void addNews(NewsInfo news);

    void deleteNews(Integer newsId);

    NewsInfo toUpdateNews(Integer newsId);

    void updateNews(NewsInfo news);

    List<NewsInfo> queryNewsList2();

    void clickRateAdd(NewsInfo news);

    List<NewsInfo> initNewsStuatusList();
}
