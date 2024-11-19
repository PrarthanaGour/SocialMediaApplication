package com.socialmedia.test.controller;

import com.socialmedia.test.dto.UserDto;
import com.socialmedia.test.entities.FollowInformation;
import com.socialmedia.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer userid)
    {
        return ResponseEntity.ok(userService.getUser(userid));
    }

    @PostMapping("/User")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("{userId}/follow/{influencerId}")
    public ResponseEntity<FollowInformation> followInfluencer(@PathVariable Integer userId, @PathVariable Integer influencerId)
    {
        FollowInformation user = userService.followInfluencer(userId,influencerId);
        return ResponseEntity.ok(user);

    }

    @PutMapping("updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId,userDto));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId)
    {
         userService.deleteUser(userId);
    }
}
