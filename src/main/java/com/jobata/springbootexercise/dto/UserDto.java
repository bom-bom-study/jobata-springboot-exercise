package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String nickname;

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
    }
}
