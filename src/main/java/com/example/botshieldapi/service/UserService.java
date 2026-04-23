package com.example.botshieldapi.service;

import com.example.botshieldapi.dto.requests.PostRequest;
import com.example.botshieldapi.dto.requests.UserRequest;
import com.example.botshieldapi.dto.response.PostResponse;
import com.example.botshieldapi.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    public UserResponse registerUser(UserRequest request);
    public List<PostResponse> allposts(Long userId);
    public UserResponse getUserById(Long userId);
}
