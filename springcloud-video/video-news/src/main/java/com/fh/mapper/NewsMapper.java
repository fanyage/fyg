package com.fh.mapper;

import com.fh.common.ServerResponse;
import com.fh.entity.NewsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {
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
