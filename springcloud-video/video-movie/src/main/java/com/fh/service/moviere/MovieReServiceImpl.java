package com.fh.service.moviere;

import com.fh.mapper.MovieReMapper;
import com.fh.model.Area;
import com.fh.model.Movie;
import com.fh.model.Type;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReServiceImpl implements MovieReService {
    @Autowired
    private MovieReMapper movieReMapper;

    @Override
    public ServerResponse queryListMovie() {
        List<Movie> movieList=movieReMapper.queryListMovie();
        return  ServerResponse.success(movieList);
    }

    @Override
    public ServerResponse queryListType() {
        List<Type> typeList=movieReMapper.queryListType();
        return ServerResponse.success(typeList);
    }

    @Override
    public ServerResponse queryListArea() {
        List<Area> areaList=movieReMapper.queryListArea();
        return ServerResponse.success(areaList);
    }

    @Override
    public ServerResponse initType(Integer typeId) {
       List<Movie>   movie=movieReMapper.initType(typeId);
        return ServerResponse.success(movie);
    }

    @Override
    public ServerResponse initArea(Integer areaId) {
        List<Movie>  movie=movieReMapper.initArea(areaId);
        return ServerResponse.success(movie);
    }

    @Override
    public ServerResponse initNum(Integer movieId) {
        Movie movie=movieReMapper.initNum(movieId);
        return ServerResponse.success(movie);
    }
}
