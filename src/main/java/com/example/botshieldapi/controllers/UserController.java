package com.example.botshieldapi.controllers;

import com.example.botshieldapi.dto.requests.UserRequest;
import com.example.botshieldapi.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.botshieldapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
UserService userService;
@PostMapping
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
    return ResponseEntity.ok(userService.registerUser(userRequest));
}
@GetMapping("/{userId}")
public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId) {
    return ResponseEntity.ok(userService.getUserById(userId));
}
@GetMapping("/{userId}/posts")
    public ResponseEntity<?> allPosts(@PathVariable Long userId) {
    return ResponseEntity.ok(userService.allposts(userId));
}
}
