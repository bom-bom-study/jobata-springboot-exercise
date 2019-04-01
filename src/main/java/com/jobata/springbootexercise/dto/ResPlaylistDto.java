package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.Playlist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPlaylistDto {
    Long id;
    Long userId;
    String title;

    public ResPlaylistDto(Playlist playlist) {
        this.id = playlist.getId();
        this.userId = playlist.getUserId();
        this.title = playlist.getTitle();
    }
}
