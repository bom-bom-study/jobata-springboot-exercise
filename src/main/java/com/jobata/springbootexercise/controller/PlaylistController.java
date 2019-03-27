package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.PlaylistDto;
import com.jobata.springbootexercise.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping(value = "/users/{user-id}/playlists")
    public ResponseEntity<List<PlaylistDto>> getPlaylists() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.getPlaylists());
    }

    @PostMapping(value = "/users/{user-id}/playlists")
    public ResponseEntity postPlaylist(@RequestBody PlaylistDto playlistDto) {
        playlistService.postPlaylist(playlistDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity<PlaylistDto> getPlaylist(@PathVariable(value = "playlist-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.getPlaylist(id));
    }

    @PatchMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity patchPlaylist(@PathVariable(value = "playlist-id") Long id, @RequestBody PlaylistDto playlistDto) {
        playlistService.patchPlaylist(id, playlistDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity deletePlaylist(@PathVariable(value = "playlist-id") Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
