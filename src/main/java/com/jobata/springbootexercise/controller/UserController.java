package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.UserDto;
import com.jobata.springbootexercise.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @PostMapping(value = "/users")
    public ResponseEntity postUser(@RequestBody UserDto userDto) {
        userService.postUser(userDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/users/{user-id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "user-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @PatchMapping(value = "/users/{user-id}")
    public ResponseEntity patchUser(@PathVariable(value = "user-id") Long id, @RequestBody UserDto userDto) {
        userService.patchUser(id, userDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/users/{user-id}")
    public ResponseEntity deleteUser(@PathVariable(value = "user-id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
