package com.jobata.springbootexercise.dto;

import com.jobata.springbootexercise.domain.Playlist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto {
    Long id;
    Long userId;
    String title;

    public PlaylistDto(Playlist playlist) {
        this.id = playlist.getId();
        this.userId = playlist.getUserId();
        this.title = playlist.getTitle();
    }
}
