package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.MusicDao;
import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.MusicDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {
    private final MusicDao musicDao;

    public MusicService(MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public List<MusicDto> getMusics() {
        List<Music> musics = musicDao.getMusics();
        List<MusicDto> musicDtos = new ArrayList<>();

        for(Music music : musics) {
            musicDtos.add(new MusicDto(music));
        }

        return musicDtos;
    }

    public void postMusic(MusicDto musicDto) {
        musicDao.postMusic(musicDto);
    }

    public MusicDto getMusic(Long id) {
        return new MusicDto(musicDao.getMusic(id));
    }

    public void patchMusic(Long id, MusicDto musicDto) {
        musicDao.patchMusic(id, musicDto);
    }

    public void deleteMusic(Long id) {
        musicDao.deleteMusic(id);
    }
}
