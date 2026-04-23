package com.example.botshieldapi.exception;

import com.example.botshieldapi.dto.response.LikeResponse;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }


}
