package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.ReqUserDto;
import com.jobata.springbootexercise.dto.ResUserDto;
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
    public ResponseEntity<List<ResUserDto>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @PostMapping(value = "/users")
    public ResponseEntity postUser(@RequestBody ReqUserDto reqUserDto) {
        userService.postUser(reqUserDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/users/{user-id}")
    public ResponseEntity<ResUserDto> getUser(@PathVariable(value = "user-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @PatchMapping(value = "/users/{user-id}")
    public ResponseEntity patchUser(@PathVariable(value = "user-id") Long id, @RequestBody ReqUserDto reqUserDto) {
        userService.patchUser(id, reqUserDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/users/{user-id}")
    public ResponseEntity deleteUser(@PathVariable(value = "user-id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
