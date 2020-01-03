package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Comment;
import com.fh.model.CommentReply;
import com.fh.model.Great;
import com.fh.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /*增加评论*/
    @RequestMapping("addComment")
    public ServerResponse addComment(Comment comment){

        return commentService.addComment(comment);
    }

    /*查询评论*/
    @RequestMapping("queryComment")
    public ServerResponse queryComment(Integer videoId){
        List<Comment> commentList = commentService.queryComment(videoId);
        return ServerResponse.success(commentList);
    }

    /*根据评论id查询回复*/
    @RequestMapping("queryReplyByCommonId")
    public ServerResponse queryReplyByCommonId(Integer commentId){
        List<CommentReply> commentReplyList = commentService.queryReplyByCommentId(commentId);
        return ServerResponse.success(commentReplyList);
    }


    /*查询全部评论回复*/
    @RequestMapping("queryAllComment")
    public ServerResponse queryAllComment(Integer videoId){
        /*根据影视id查询该影视的所有评论*/
        List<Comment> commentList = commentService.queryComment(videoId);
        List<CommentReply> commentReplyList = null;
        for (Comment comment : commentList) {
            Integer commentId = comment.getCommentId();
            //根据每条评论id查询该评论下的所有回复
            commentReplyList = commentService.queryReplyByCommentId(commentId);
        }

        Map map = new HashMap();
        map.put("commentList",commentList);
        map.put("commentReplyList",commentReplyList);
        return ServerResponse.success(map);
    }

    /*增加回复*/
    @RequestMapping("addCommentReply")
    public ServerResponse addCommentReply(CommentReply commentReply){
        commentService.addCommentReply(commentReply);
        return ServerResponse.success();
    }

    /*删除回复*/
    @RequestMapping("delReplyByReplyId")
    public ServerResponse delReplyByReplyId(Integer replyId){
        commentService.delReplyByReplyId(replyId);
        return ServerResponse.success();
    }


    /*删除评论并删除该评论下的所有回复*/
    @RequestMapping("delCommentByCommentId")
    public ServerResponse delCommentByCommentId(Integer commentId){
        /*根据评论id删除评论*/
        commentService.delCommentByCommentId(commentId);
        /*根据评论id删除回复*/
        commentService.delReplyByCommentId(commentId);
        return ServerResponse.success();
    }

    /*根据用户id查询该用户的评论*/
    @RequestMapping("queryCommentByUserId")
    public ServerResponse queryCommentByUserId(Integer userId){
        List<Comment> commentList = commentService.queryCommentByUserId(userId);
        return ServerResponse.success(commentList);
    }

    /*根据用户id查询改用户的回复*/
    @RequestMapping("queryReplyByUserId")
    public ServerResponse queryReplyByUserId(Integer userId){
        List<CommentReply> commentReplyList = commentService.queryReplyByUserId(userId);
        return ServerResponse.success(commentReplyList);
    }

    /*根据用户id查询回复该用户的回复*/
    @RequestMapping("queryReplyByReplyUserId")
    public ServerResponse queryReplyByReplyUserId(Integer replyUserId){
        List<CommentReply> commentReplyList = commentService.queryReplyByReplyUserId(replyUserId);
        return ServerResponse.success(commentReplyList);
    }

    /*点赞*/
    @RequestMapping("giveLike")
    public ServerResponse giveLike(Integer commentId,Integer userId){
        Comment comment = commentService.queryCommentById(commentId);
        /*根据评论id及用户id查询点赞表查看用户是否给该评论点过赞*/
        List<Great> greats = commentService.queryGreatById(commentId,userId);
        /*如果查询到信息证明该用户给该评论点过赞*/
        if(greats!=null && greats.size()>0){
            comment.setCommentLike(comment.getCommentLike()-1);
            /*给该评论赞-1*/
            commentService.updateCommentLike(comment);
            /*删除点赞表中的数据*/
            commentService.deleteGreatById(commentId,userId);
        }
        /*如果查询到信息证明该用户没有给该评论点过赞*/
        if(greats.size()==0){
            comment.setCommentLike(comment.getCommentLike()+1);
            /*给该评论赞+1*/
            commentService.updateCommentLike(comment);
            /*点赞表中增加数据*/
            commentService.AddGreat(comment);
        }
        return ServerResponse.success();
    }

}
