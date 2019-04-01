package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.MusicDao;
import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.ReqMusicDto;
import com.jobata.springbootexercise.dto.ResMusicDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicService {
    private final MusicDao musicDao;

    public MusicService(MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public List<ResMusicDto> getMusics() {
        List<Music> musics = musicDao.getMusics();

        return musics.stream().map(ResMusicDto::new).collect(Collectors.toList());
    }

    public void postMusic(ReqMusicDto reqMusicDto) {
        musicDao.postMusic(reqMusicDto.getTitle(), reqMusicDto.getSinger());
    }

    public ResMusicDto getMusic(Long id) {
        return new ResMusicDto(musicDao.getMusic(id));
    }

    public void patchMusic(Long id, ReqMusicDto reqMusicDto) {
        musicDao.patchMusic(id, reqMusicDto.getTitle(), reqMusicDto.getSinger());
    }

    public void deleteMusic(Long id) {
        musicDao.deleteMusic(id);
    }
}
