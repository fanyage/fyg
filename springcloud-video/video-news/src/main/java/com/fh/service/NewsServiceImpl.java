package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.entity.NewsInfo;
import com.fh.mapper.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;

    @Override
    public Integer queryCount(NewsInfo news) {
        return newsMapper.queryCount(news);
    }

    @Override
    public List<Map<String, Object>> queryNewsList(NewsInfo news) {
            return newsMapper.queryNewsList(news);
    }

    @Override
    public void addNews(NewsInfo news) {
   newsMapper.addNews(news);
    }

    @Override
    public void deleteNews(Integer newsId) {
        newsMapper.deleteNews(newsId);
    }

    @Override
    public NewsInfo toUpdateNews(Integer newsId) {
        return newsMapper.toUpdateNews(newsId);
    }

    @Override
    public void updateNews(NewsInfo news) {
        newsMapper.updateNews(news);
    }

    @Override
    public List<NewsInfo> queryNewsList2() {
        return newsMapper.queryNewsList2();
    }

    @Override
    public void clickRateAdd(NewsInfo news) {
        newsMapper.clickRateAdd(news);
    }

    @Override
    public List<NewsInfo> initNewsStuatusList() {
        return newsMapper.initNewsStuatusList();
    }


}
