package com.jobata.springbootexercise.controller;

import com.jobata.springbootexercise.dto.MusicDto;
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
    public ResponseEntity<List<MusicDto>> getMusics() {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getMusics());
    }

    @PostMapping(value = "/musics")
    public ResponseEntity postMusic(@RequestBody MusicDto musicDto) {
        musicService.postMusic(musicDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/musics/{music-id}")
    public ResponseEntity<MusicDto> getMusic(@PathVariable(value = "music-id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.getMusic(id));
    }

    @PatchMapping(value = "/musics/{music-id}")
    public ResponseEntity patchMusic(@PathVariable(value = "music-id") Long id, @RequestBody MusicDto musicDto) {
        musicService.patchMusic(id, musicDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(value = "/musics/{music-id}")
    public ResponseEntity deleteMusic(@PathVariable(value = "music-id") Long id) {
        musicService.deleteMusic(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
