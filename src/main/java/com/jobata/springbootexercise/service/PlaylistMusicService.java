package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.PlaylistMusicDao;
import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.MusicDto;
import com.jobata.springbootexercise.dto.PlaylistMusicDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistMusicService {
    private final PlaylistMusicDao playlistMusicDao;

    public PlaylistMusicService(PlaylistMusicDao playlistMusicDao) {
        this.playlistMusicDao = playlistMusicDao;
    }

    public void postPlaylistMusic(Long id, PlaylistMusicDto playlistMusicDto) {
        playlistMusicDao.postPlaylistMusic(id, playlistMusicDto);
    }

    public List<MusicDto> getPlaylistMusics(Long id) {
        List<Music> musics = playlistMusicDao.getPlaylistMusics(id);

        return musics.stream().map(MusicDto::new).collect(Collectors.toList());
    }

    public void deletePlaylistMusic(Long playlistId, Long musicId) {
        playlistMusicDao.deletePlaylistMusic(playlistId, musicId);
    }
}
