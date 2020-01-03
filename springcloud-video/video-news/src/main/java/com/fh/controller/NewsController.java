package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.entity.NewsInfo;
import com.fh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("news")
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsService newsService;

    //点击量
    @RequestMapping("clickRateAdd")
    @ResponseBody
    public ServerResponse clickRateAdd(NewsInfo news){
        newsService.clickRateAdd(news);
        return  ServerResponse.success();
    }
    @RequestMapping("queryNewsList")
    @ResponseBody
    public Map<String, Object> queryNewsList(NewsInfo news){
        Map<String, Object> map = new HashMap<>();
        //查询总条数
        Integer count = newsService.queryCount(news);
        //查询分页数据
        List<Map<String,Object>> animalList=newsService.queryNewsList(news);
        map.put("data",animalList);
        map.put("recordsTotal",count);
        map.put("draw",news.getDrew());
        map.put("recordsFiltered",count);
        return map;
    }
    @RequestMapping("/queryNewsList2")
    @ResponseBody
    public ServerResponse queryNewsList2(){
        List<NewsInfo> list=newsService.queryNewsList2();
        return  ServerResponse.success(list);
    }
    @RequestMapping("/initNewsStuatusList")
    @ResponseBody
    public ServerResponse initNewsStuatusList(){
        List<NewsInfo> list=newsService.initNewsStuatusList();
        return  ServerResponse.success(list);
    }
    /*
    * 新闻新增
    * */
    @RequestMapping("addNews")
    @ResponseBody
    public ServerResponse addNews(NewsInfo news){
        newsService.addNews(news);
        return ServerResponse.success();
    }
    /*
    * 删除新闻
    * */
    @RequestMapping("deleteNews")
    @ResponseBody
    public  ServerResponse deleteNews(Integer newsId){
        newsService.deleteNews(newsId);
        return ServerResponse.success();
    }

    /*
     * 回显
     * */
    @RequestMapping("toUpdateNews")
    @ResponseBody
    public ServerResponse toUpdateNews(Integer newsId) {
        NewsInfo newsInfo=newsService.toUpdateNews(newsId);
        return ServerResponse.success(newsInfo);
    }
    /*
    * 修改
    * */
    @RequestMapping("updateNews")
    @ResponseBody
    public ServerResponse updateNews(NewsInfo news){
        newsService.updateNews(news);
        return ServerResponse.success();

    }
}
