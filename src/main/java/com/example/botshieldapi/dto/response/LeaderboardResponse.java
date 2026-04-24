package com.example.botshieldapi.dto.response;
public class LeaderboardResponse {

    private Long postId;
    private double score;

    public LeaderboardResponse(Long postId, double score) {
        this.postId = postId;
        this.score = score;
    }

    public Long getPostId() {
        return postId;
    }

    public double getScore() {
        return score;
    }
}
