package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResUserDto {
    Long id;
    String nickname;

    public ResUserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
    }
}
