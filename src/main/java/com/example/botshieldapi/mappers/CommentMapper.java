package com.example.botshieldapi.mappers;

import com.example.botshieldapi.dto.response.CommentResponse;
import com.example.botshieldapi.entity.Comment;

public class CommentMapper {
    public static CommentResponse mapToCommentResponse(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getCommentId());
        commentResponse.setBotId(comment.getBotId());
        commentResponse.setContent(comment.getContent());
        commentResponse.setCreatedAt(comment.getCreatedAt());
        commentResponse.setPostId(comment.getPostId());
        commentResponse.setParentCommentId(comment.getParentCommentId());
        commentResponse.setUserId(comment.getUserId());
        commentResponse.setDepthLevel(comment.getDepthLevel());
        return commentResponse;
    }
}
