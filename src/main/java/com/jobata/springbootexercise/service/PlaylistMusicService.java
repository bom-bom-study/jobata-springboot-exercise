package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.PlaylistMusicDao;
import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistMusicService {
    private final PlaylistMusicDao playlistMusicDao;

    public PlaylistMusicService(PlaylistMusicDao playlistMusicDao) {
        this.playlistMusicDao = playlistMusicDao;
    }

    public void postPlaylistMusic(Long id, ReqPlaylistMusicDto reqPlaylistMusicDto) {
        playlistMusicDao.postPlaylistMusic(id, reqPlaylistMusicDto.getMusicId());
    }

    public List<ResPlaylistMusicDto> getPlaylistMusics(Long id) {
        List<Music> musics = playlistMusicDao.getPlaylistMusics(id);

        return musics.stream().map(ResPlaylistMusicDto::new).collect(Collectors.toList());
    }

    public void deletePlaylistMusic(Long playlistId, Long musicId) {
        playlistMusicDao.deletePlaylistMusic(playlistId, musicId);
    }
}
