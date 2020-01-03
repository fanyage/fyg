package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.model.Comment;
import com.fh.model.CommentReply;
import com.fh.model.Great;

import java.util.List;

public interface CommentService {

    /*增加评论*/
    ServerResponse addComment(Comment comment);

    /*查询评论*/
    List<Comment> queryComment(Integer videoId);

    List<CommentReply> queryReplyByCommentId(Integer commentId);

    /*增加回复*/
    void addCommentReply(CommentReply commentReply);
    /*删除回复*/
    void delReplyByReplyId(Integer replyId);
    /*根据评论id删除评论*/
    void delCommentByCommentId(Integer commentId);
    /*根据评论id删除回复*/
    void delReplyByCommentId(Integer commentId);
    /*根据用户id查询改用户的评论*/
    List<Comment> queryCommentByUserId(Integer userId);
    /*根据用户id查询该用户的回复*/
    List<CommentReply> queryReplyByUserId(Integer userId);
    /*根据用户id查询回复该用户的回复*/
    List<CommentReply> queryReplyByReplyUserId(Integer replyUserId);
    /*根据评论id及用户id查询点赞表查看用户是否给该评论点过赞*/
    List<Great> queryGreatById(Integer commentId, Integer userId);
    /*给用户点赞或取消赞*/
    void updateCommentLike(Comment comment);
    /*删除点赞表中的数据*/
    void deleteGreatById(Integer commentId, Integer userId);
    /*给点赞表增加数据*/
    void AddGreat(Comment comment);
    /*根据评论id查询评论*/
    Comment queryCommentById(Integer commentId);
}
