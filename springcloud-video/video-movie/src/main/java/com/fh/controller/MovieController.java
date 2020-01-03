package com.fh.controller;

import com.fh.model.Movie;
import com.fh.parm.MovieParm;
import com.fh.service.movie.MovieService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movie/")
@CrossOrigin
public class MovieController {
        @Autowired
        private MovieService movieService;

        /**
         * 电影分页条件查询
         * @param movieParm
         * 条件查询的javaBean
         * @return
         */
        @RequestMapping("queryListMovie")
        public ServerResponse   queryListMovie(MovieParm movieParm){
                Long totalCount = movieService.queryTotalCount(movieParm);
                List<Movie> list = movieService.queryList(movieParm);
                Map map = new HashMap();
                map.put( "data", list );
                map.put( "recordsTotal", totalCount );
                map.put( "recordsFiltered", totalCount );
                map.put( "draw", movieParm.getDraw() );
              return   ServerResponse.success(map);
        }

        /**
         * 电影的添加
         * @param movie
         * @return
         */
        @RequestMapping("addListMovie")
        public   ServerResponse  addListMovie(Movie movie){
                movieService.addListMovie(movie);
                return  ServerResponse.success();
        }



        /**
        * 根据ID进行查询 做回显效果
        * @param movieId
        * @return
        */
         @RequestMapping("getMovieById")
        public  ServerResponse getMovieById(Integer movieId){
            return  movieService.getMovieById(movieId);
        }

        /**
         *   电影的修改操作
         * @param movie
         * @return
         */
        @RequestMapping("updateListMovie")
        public  ServerResponse updateListMovie(Movie movie){
                movieService.updateListMovie(movie);
            return  ServerResponse.success();
        }
        /**
         * 删除电影信息
         */
        @RequestMapping("deleteListMovie")
        public  ServerResponse deleteListMovie(Integer movieId){
            return  movieService.deleteListMovie(movieId);
        }

        /**
         * 查询电影类型
         * @return
         */
        @RequestMapping("queryListType")
        public  ServerResponse  queryListType(){
            return  movieService.queryListType();
        }

        /**
         * 查询电影所属地区
         * @return
         */
        @RequestMapping("queryListArea")
        public  ServerResponse  queryListArea(){
            return  movieService.queryListArea();
        }

}
