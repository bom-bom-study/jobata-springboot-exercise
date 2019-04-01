package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.PlaylistDao;
import com.jobata.springbootexercise.domain.Playlist;
import com.jobata.springbootexercise.dto.PlaylistDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    private final PlaylistDao playlistDao;

    public PlaylistService(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    public List<PlaylistDto> getPlaylists() {
        List<Playlist> playlists = playlistDao.getPlaylists();

        return playlists.stream().map(PlaylistDto::new).collect(Collectors.toList());
    }

    public void postPlaylist(PlaylistDto playlistDto) {
        playlistDao.postPlaylist(playlistDto);
    }

    public PlaylistDto getPlaylist(Long id) {
        return new PlaylistDto(playlistDao.getPlaylist(id));
    }

    public void patchPlaylist(Long id, PlaylistDto playlistDto) {
        playlistDao.patchPlaylist(id, playlistDto);
    }

    public void deletePlaylist(Long id) {
        playlistDao.deletePlaylist(id);
    }
}
