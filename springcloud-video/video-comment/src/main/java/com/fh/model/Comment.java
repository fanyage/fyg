package com.fh.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Comment {

    private Integer commentId;                      //主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String  commentContent;                 //评论内容
    private Date    commentTime;                    //评论时间
    private Integer commentLike;                    //点赞
    private Integer commentLook;                    //浏览量

    private Integer videoId;                        //视频id

    private Integer userId;                         //用户id
    private String  userName;                       //用户姓名
    private String  userPicture;                    //用户头像
    private List<CommentReply> commentReplyList;    //该评论的所有回复

}
