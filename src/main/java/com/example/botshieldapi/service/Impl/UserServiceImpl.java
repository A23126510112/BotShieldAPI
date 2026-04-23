package com.example.botshieldapi.service.Impl;


import com.example.botshieldapi.dto.requests.PostRequest;
import com.example.botshieldapi.dto.requests.UserRequest;

import com.example.botshieldapi.dto.response.PostResponse;
import com.example.botshieldapi.dto.response.UserResponse;
import com.example.botshieldapi.entity.Post;
import com.example.botshieldapi.entity.User;

import com.example.botshieldapi.exception.ResourceNotFoundException;
import com.example.botshieldapi.mappers.PostMapper;
import com.example.botshieldapi.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import com.example.botshieldapi.mappers.UserMapper;
import org.springframework.stereotype.Service;
import com.example.botshieldapi.repository.UserRepository;
import com.example.botshieldapi.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    PostRepository postRepository;
    @Override
    public UserResponse registerUser(UserRequest request) {
        User newUser = new User();
        newUser.setUserName(request.getUserName());
        newUser.setIsPremium(request.getIsPremium());
        newUser.setCreatedAt(LocalDateTime.now());
        userRepository.save(newUser);
        return UserMapper.mapToUserResponse(newUser);
    }

    @Override
    public List<PostResponse> allposts(Long userId) {
        List<Post> posts=postRepository.findAllByUserId(userId);
        return posts.stream().map(PostMapper::mapToPostResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with id:"+userId));
        return UserMapper.mapToUserResponse(user);
    }


}
