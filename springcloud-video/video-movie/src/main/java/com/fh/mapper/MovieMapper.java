package com.fh.mapper;

import com.fh.model.Area;
import com.fh.model.Movie;
import com.fh.model.Type;
import com.fh.parm.MovieParm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieMapper {
    Long queryTotalCount(MovieParm movieParm);

    List<Movie> queryList(MovieParm movieParm);

    void addListMovie(Movie movie);

    Movie getMovieById(Integer movieId);

    void updateListMovie(Movie movie);

    void deleteListMovie(Integer movieId);

    List<Type> queryListType();

    List<Area> queryListArea();
}