package com.fh.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CommentReply {

    private Integer replyId;                     //联合主键
    private String  replyContent;                  //回复内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    replyTime;                     //回复时间

    private Integer userId;                        //用户id
    private String  userName;                      //用户姓名
    private String  userPicture;                   //用户头像
    private Integer replyUserId;                   //回复用户id
    private String  replyUserName;                 //回复用户name
    private Integer commentId;                     //评论id

}
