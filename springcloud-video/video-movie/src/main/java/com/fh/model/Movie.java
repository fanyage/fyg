package com.fh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Movie {
    private   Integer  movieId;
    private   String   movieName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private   Date     showTime;
    private   String   movieIntro;//电影简介
    private   Integer  vipStatus;//是否为vip电影   1 免费  2 vip状态
    private   Integer  movieStatus;//是否上映   1  上映   2 未上映
    private   Double   movieScore;//电影评分
    private   String   count;//电影播放量
    private   String   filePath;//电影主题
    private   Integer  userId;//所属用户，方便后期制作，用户上传自己的视频
    private   Integer  typeId;//电影的类型
    private   Integer  areaId;//电影所属产地

    //沉余字段
    private  String   typeName;
    private  String   areaName;
    private  String   userName;


    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", showTime=" + showTime +
                ", movieIntro='" + movieIntro + '\'' +
                ", vipStatus=" + vipStatus +
                ", movieStatus=" + movieStatus +
                ", count='" + count + '\'' +
                ", filePath='" + filePath + '\'' +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", areaId=" + areaId +
                '}';
    }

    public Movie(Integer movieId, String movieName, Date showTime, String movieIntro, Integer vipStatus, Integer movieStatus, String count, String filePath, Integer userId, Integer typeId, Integer areaId) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showTime = showTime;
        this.movieIntro = movieIntro;
        this.vipStatus = vipStatus;
        this.movieStatus = movieStatus;
        this.count = count;
        this.filePath = filePath;
        this.userId = userId;
        this.typeId = typeId;
        this.areaId = areaId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getMovieIntro() {
        return movieIntro;
    }

    public void setMovieIntro(String movieIntro) {
        this.movieIntro = movieIntro;
    }

    public Integer getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(Integer vipStatus) {
        this.vipStatus = vipStatus;
    }

    public Integer getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(Integer movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
