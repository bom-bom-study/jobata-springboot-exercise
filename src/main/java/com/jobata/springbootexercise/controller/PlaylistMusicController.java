package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.MusicDto;
import com.jobata.springbootexercise.dto.PlaylistMusicDto;
import com.jobata.springbootexercise.service.PlaylistMusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistMusicController {
    private final PlaylistMusicService playlistMusicService;

    public PlaylistMusicController(PlaylistMusicService playlistMusicService) {
        this.playlistMusicService = playlistMusicService;
    }

    @PostMapping(value = "/users/{user-id}/playlists/{playlist-id}/musics")
    public ResponseEntity postPlaylistMusic(@PathVariable(value = "playlist-id") Long id, @RequestBody PlaylistMusicDto playlistMusicDto) {
        playlistMusicService.postPlaylistMusic(id, playlistMusicDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/users/{user-id}/playlists/{playlist-id}/musics")
    public ResponseEntity<List<MusicDto>> getPlaylistMusics(@PathVariable(value = "playlist-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistMusicService.getPlaylistMusics(id));
    }

    @DeleteMapping(value = "/users/{user-id}/playlists/{playlist-id}/musics/{music-id}")
    public ResponseEntity deletePlaylistMusic(@PathVariable(value = "playlist-id") Long playlistId, @PathVariable(value = "music-id") Long musicId) {
        playlistMusicService.deletePlaylistMusic(playlistId, musicId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
