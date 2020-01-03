package com.fh.service.impl;

import com.fh.common.ResponseEnum;
import com.fh.common.ServerResponse;
import com.fh.mapper.CommentMapper;
import com.fh.model.Comment;
import com.fh.model.CommentReply;
import com.fh.model.Great;
import com.fh.service.CommentService;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private UserService userService;//

    /*增加评论*/
    @Override
    public ServerResponse addComment(Comment comment) {
        Integer userId = comment.getUserId();
        ServerResponse serverResponse = userService.queryById(userId);

        if(serverResponse.getStatus() !=200){

           return ServerResponse.error(ResponseEnum.ERROR);
        }
        if (serverResponse.getData() == null){
           return ServerResponse.error(ResponseEnum.USER_NULL);
        }
        Map userMassage = (Map) serverResponse.getData();
            comment.setUserName((String) userMassage.get("userName"));
            comment.setUserPicture((String) userMassage.get("userPath"));
            comment.setCommentLike(0);
            comment.setCommentTime(new Date());
            comment.setCommentLook(0);
            commentMapper.addComment(comment);

        return ServerResponse.success();
    }

    /*查询评论*/
    @Override
    public List<Comment> queryComment(Integer videoId) {
        return commentMapper.queryComment(videoId);
    }

    @Override
    public List<CommentReply> queryReplyByCommentId(Integer commentId) {
        return commentMapper.queryReplyByCommentId(commentId);
    }

    /*增加回复*/
    @Override
    public void addCommentReply(CommentReply commentReply) {

        commentReply.setReplyTime(new Date());
        commentMapper.addCommentReply(commentReply);
    }

    /*删除回复*/
    @Override
    public void delReplyByReplyId(Integer replyId) {
        commentMapper.delReplyByReplyId(replyId);
    }

    /*删除评论*/
    @Override
    public void delCommentByCommentId(Integer commentId) {
        commentMapper.delCommentByCommentId(commentId);
    }
    /*根据评论id删除回复*/
    @Override
    public void delReplyByCommentId(Integer commentId) {
        commentMapper.delReplyByCommentId(commentId);
    }

    /*根据用户id查询该用户的评论*/
    @Override
    public List<Comment> queryCommentByUserId(Integer userId) {
        return commentMapper.queryCommentByUserId(userId);
    }

    /*根据用户id查询该用户的回复*/
    @Override
    public List<CommentReply> queryReplyByUserId(Integer userId) {
        return commentMapper.queryReplyByUserId(userId);
    }

    /*根据用户id查询回复该用户的回复*/
    @Override
    public List<CommentReply> queryReplyByReplyUserId(Integer replyUserId) {
        return commentMapper.queryReplyByReplyUserId(replyUserId);
    }
    /*根据评论id及用户id查询点赞表查看用户是否给该评论点过赞*/
    @Override
    public List<Great> queryGreatById(Integer commentId, Integer userId) {
        return commentMapper.queryGreatById(commentId, userId);
    }

    /*给用户点赞或取消赞*/
    @Override
    public void updateCommentLike(Comment comment) {
        commentMapper.updateCommentLike(comment);
    }

    @Override
    public void deleteGreatById(Integer commentId, Integer userId) {
        commentMapper.deleteGreatById(commentId, userId);
    }

    @Override
    public void AddGreat(Comment comment) {
        commentMapper.AddGreat(comment);
    }

    @Override
    public Comment queryCommentById(Integer commentId) {
        return commentMapper.queryCommentById(commentId);
    }
}
