package com.example.botshieldapi.mappers;

import com.example.botshieldapi.dto.response.UserResponse;
import com.example.botshieldapi.entity.User;

public class UserMapper {
    public static UserResponse mapToUserResponse(User userRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userRequest.getId());
        userResponse.setUserName(userRequest.getUserName());
        userResponse.setIsPremium(userRequest.getIsPremium());
        userResponse.setCreatedAt(userRequest.getCreatedAt());
        return userResponse;
    }
}
