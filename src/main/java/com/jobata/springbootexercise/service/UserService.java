package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.UserDao;
import com.jobata.springbootexercise.domain.User;
import com.jobata.springbootexercise.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserDto> getUsers() {
        List<User> users = userDao.getUsers();

        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

    public void postUser(UserDto userDto) {
        userDao.postUser(userDto);
    }

    public UserDto getUser(Long id) {
        return new UserDto(userDao.getUser(id));
    }

    public void patchUser(Long id, UserDto userDto) {
        userDao.patchUser(id, userDto);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
