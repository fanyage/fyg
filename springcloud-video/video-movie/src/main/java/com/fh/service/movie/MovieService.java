package com.fh.service.movie;

import com.fh.model.Movie;
import com.fh.parm.MovieParm;
import com.fh.common.ServerResponse;

import java.util.List;

public interface MovieService {
    Long queryTotalCount(MovieParm movieParm);

    List<Movie> queryList(MovieParm movieParm);

    void addListMovie(Movie movie);

    ServerResponse getMovieById(Integer movieId);

    void updateListMovie(Movie movie);

    ServerResponse deleteListMovie(Integer movieId);

    ServerResponse queryListType();

    ServerResponse queryListArea();
}
