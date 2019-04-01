package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.ReqPlaylistDto;
import com.jobata.springbootexercise.dto.ResPlaylistDto;
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
    public ResponseEntity<List<ResPlaylistDto>> getPlaylists() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.getPlaylists());
    }

    @PostMapping(value = "/users/{user-id}/playlists")
    public ResponseEntity postPlaylist(@RequestBody ReqPlaylistDto reqPlaylistDto) {
        playlistService.postPlaylist(reqPlaylistDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity<ResPlaylistDto> getPlaylist(@PathVariable(value = "playlist-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.getPlaylist(id));
    }

    @PatchMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity patchPlaylist(@PathVariable(value = "playlist-id") Long id, @RequestBody ReqPlaylistDto reqPlaylistDto) {
        playlistService.patchPlaylist(id, reqPlaylistDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/users/{user-id}/playlists/{playlist-id}")
    public ResponseEntity deletePlaylist(@PathVariable(value = "playlist-id") Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
