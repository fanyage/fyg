package com.fh.service.movie;

import com.fh.mapper.MovieMapper;
import com.fh.model.Area;
import com.fh.model.Movie;
import com.fh.model.Type;
import com.fh.parm.MovieParm;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements  MovieService {
        @Autowired
        private MovieMapper   movieMapper;

        @Override
        public Long queryTotalCount(MovieParm movieParm) {

                return movieMapper.queryTotalCount(movieParm);
        }

        @Override
        public List<Movie> queryList(MovieParm movieParm) {
                return movieMapper.queryList(movieParm);
        }

        @Override
        public void addListMovie(Movie movie) {
            movieMapper.addListMovie(movie);
        }

        @Override
        public ServerResponse getMovieById(Integer movieId) {
                Movie movie=movieMapper.getMovieById(movieId);
            return ServerResponse.success(movie);
        }

        @Override
        public void updateListMovie(Movie movie) {
            movieMapper.updateListMovie(movie);
        }

        @Override
        public ServerResponse deleteListMovie(Integer movieId) {
                movieMapper.deleteListMovie(movieId);
            return ServerResponse.success();
        }

    @Override
    public ServerResponse queryListType() {
            List<Type> typeList=movieMapper.queryListType();
        return ServerResponse.success(typeList);
    }

    @Override
    public ServerResponse queryListArea() {
        List<Area> areaList=movieMapper.queryListArea();
        return ServerResponse.success(areaList);
    }

}
