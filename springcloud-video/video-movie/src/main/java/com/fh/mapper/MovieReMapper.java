package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.Movie;
import com.fh.model.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MovieReMapper {
    List<Movie> queryListMovie();

    List<Type> queryListType();

    List<Area> queryListArea();

    List<Movie> initType(Integer typeId);

    List<Movie> initArea(Integer areaId);

    Movie initNum(Integer movieId);
}