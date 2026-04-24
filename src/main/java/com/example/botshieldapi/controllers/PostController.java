package com.example.botshieldapi.controllers;

import com.example.botshieldapi.dto.requests.CommentRequest;
import com.example.botshieldapi.dto.requests.LikeRequest;
import com.example.botshieldapi.dto.requests.PostRequest;
import com.example.botshieldapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private RedisService redisService;
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostRequest request) {
        return ResponseEntity.ok(postService.postPost(request));
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<?> addComment(@PathVariable Long postId,  @RequestBody CommentRequest comment) {
        return ResponseEntity.ok(commentService.commentPost(postId,comment));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<?> getAllComments(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getAllComments(postId));
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<?> addLike(@PathVariable Long postId,@RequestBody LikeRequest likeRequest) {
        return ResponseEntity.ok(likeService.likeAPost(postId,likeRequest));
    }
    @GetMapping("/{postId}/likes/count")
    public ResponseEntity<?> getLikeCount(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.likesCount(postId));
    }
    @GetMapping("/{postId}/virality")
    public ResponseEntity<?> getVirality(@PathVariable Long postId) {
        return ResponseEntity.ok(redisService.get("post:"+postId+":virality_score"));
    }
    @GetMapping("/leaderboard")
    public ResponseEntity<?> getLeaderboard(@RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(redisService.getTopPosts(limit));
    }
}