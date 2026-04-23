package com.example.botshieldapi.mappers;

import com.example.botshieldapi.dto.response.PostResponse;
import com.example.botshieldapi.entity.Post;


public class PostMapper {
    public static PostResponse mapToPostResponse(Post post) {
        return new PostResponse(post.getId(),
                post.getContent(),
                post.getBotId(),
                post.getUserId(),
                post.getCreated());
    }

}
