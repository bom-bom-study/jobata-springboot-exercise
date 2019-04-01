package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.ReqMusicDto;
import com.jobata.springbootexercise.dto.ResMusicDto;
import com.jobata.springbootexercise.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping(value = "/musics")
    public ResponseEntity<List<ResMusicDto>> getMusics() {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getMusics());
    }

    @PostMapping(value = "/musics")
    public ResponseEntity postMusic(@RequestBody ReqMusicDto reqMusicDto) {
        musicService.postMusic(reqMusicDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/musics/{music-id}")
    public ResponseEntity<ResMusicDto> getMusic(@PathVariable(value = "music-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getMusic(id));
    }

    @PatchMapping(value = "/musics/{music-id}")
    public ResponseEntity patchMusic(@PathVariable(value = "music-id") Long id, @RequestBody ReqMusicDto reqMusicDto) {
        musicService.patchMusic(id, reqMusicDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/musics/{music-id}")
    public ResponseEntity deleteMusic(@PathVariable(value = "music-id") Long id) {
        musicService.deleteMusic(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
