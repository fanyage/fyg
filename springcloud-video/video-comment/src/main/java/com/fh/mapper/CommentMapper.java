package com.fh.mapper;

import com.fh.model.Comment;
import com.fh.model.CommentReply;
import com.fh.model.Great;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    /*增加评论*/
    void addComment(Comment comment);
    /*查询全部评论*/
    List<Comment> queryComment(Integer videoId);
    /*根据评论id查看回复*/
    List<CommentReply> queryReplyByCommentId(Integer commentId);
    /*增加回复*/
    void addCommentReply(CommentReply commentReply);

    /*删除回复*/
    void delReplyByReplyId(Integer replyId);
    /*删除评论*/
    void delCommentByCommentId(Integer commentId);
    /*根据评论id删除回复*/
    void delReplyByCommentId(Integer commentId);
    /*根据用户id查询该用户的评论*/
    List<Comment> queryCommentByUserId(Integer userId);
    /*根据用户id查询该用户的回复*/
    List<CommentReply> queryReplyByUserId(Integer userId);
    /*根据用户id查询回复该用户的回复*/
    List<CommentReply> queryReplyByReplyUserId(Integer replyUserId);
    /*根据评论id及用户id查询点赞表查看用户是否给该评论点过赞*/
    List<Great> queryGreatById(@Param("commentId") Integer commentId, @Param("userId") Integer userId);
    /*给用户点赞或取消赞*/
    void updateCommentLike(Comment comment);

    void deleteGreatById(@Param("commentId")Integer commentId, @Param("userId")Integer userId);

    void AddGreat(Comment comment);

    Comment queryCommentById(Integer commentId);
}
