package com.fh.model;

import com.baomidou.mybatisplus.annotation.TableField;

public class Accessory{

    private Integer accessoryId; //主键
    private Integer accessoryNumber; //集数
    private Integer movieId;  //视频id
    private String accessoryPath; //播放路径
    private String movieName; //视频名称

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getAccessoryNumber() {
        return accessoryNumber;
    }

    public void setAccessoryNumber(Integer accessoryNumber) {
        this.accessoryNumber = accessoryNumber;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getAccessoryPath() {
        return accessoryPath;
    }

    public void setAccessoryPath(String accessoryPath) {
        this.accessoryPath = accessoryPath;
    }


}
