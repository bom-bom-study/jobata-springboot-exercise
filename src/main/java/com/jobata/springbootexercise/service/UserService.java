package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.UserDao;
import com.jobata.springbootexercise.domain.User;
import com.jobata.springbootexercise.dto.ReqUserDto;
import com.jobata.springbootexercise.dto.ResUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<ResUserDto> getUsers() {
        List<User> users = userDao.getUsers();

        return users.stream().map(ResUserDto::new).collect(Collectors.toList());
    }

    public void postUser(ReqUserDto reqUserDto) {
        userDao.postUser(reqUserDto.getNickname());
    }

    public ResUserDto getUser(Long id) {
        return new ResUserDto(userDao.getUser(id));
    }

    public void patchUser(Long id, ReqUserDto reqUserDto) {
        userDao.patchUser(id, reqUserDto.getNickname());
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
