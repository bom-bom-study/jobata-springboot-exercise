package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.Music;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicDto {
    Long id;
    String title;
    String singer;

    public MusicDto(Music music) {
        this.id = music.getId();
        this.title = music.getTitle();
        this.singer = music.getSinger();
    }
}
