package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.Music;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResMusicDto {
    Long id;
    String title;
    String singer;

    public ResMusicDto(Music music) {
        this.id = music.getId();
        this.title = music.getTitle();
        this.singer = music.getSinger();
    }
}
