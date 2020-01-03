package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.service.moviere.MovieReService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("moviec/")

public class MovieReController {
    @Autowired
    private MovieReService movieReService;

    /**
     * 查询电影
     * @return
     */
    @RequestMapping("queryListMovie")
    public ServerResponse queryListMovie(){
        return  movieReService.queryListMovie();
    }
    /**
     * 查询电影类型
     * @return
     */
    @RequestMapping("queryListType")
    public ServerResponse  queryListType(){
        return  movieReService.queryListType();
    }
    /**
     * 查询电影地区
     * @return
     */
    @RequestMapping("queryListArea")
    public ServerResponse  queryListArea(){
        return  movieReService.queryListArea();
    }

    /**
     * 电影类型的条件查询
     * @param typeId
     * @return
     */
    @RequestMapping("initType")
    public ServerResponse initType(Integer typeId){
        return movieReService.initType(typeId);
    }
    /**
     * 电影地区的条件查询
     * @param areaId
     * @return
     */
    @RequestMapping("initArea")
    public ServerResponse initArea(Integer areaId){
        return movieReService.initArea(areaId);
    }
    /**
     * 电影的集数查询
     * @param movieId
     * @return
     */
    @RequestMapping("initNum")
    public ServerResponse initNum(Integer movieId){
        return movieReService.initNum(movieId);
    }



}
