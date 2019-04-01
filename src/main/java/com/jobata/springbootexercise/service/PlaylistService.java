package com.jobata.springbootexercise.service;

import com.jobata.springbootexercise.dao.PlaylistDao;
import com.jobata.springbootexercise.domain.Playlist;
import com.jobata.springbootexercise.dto.ReqPlaylistDto;
import com.jobata.springbootexercise.dto.ResPlaylistDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    private final PlaylistDao playlistDao;

    public PlaylistService(PlaylistDao playlistDao) {
        this.playlistDao = playlistDao;
    }

    public List<ResPlaylistDto> getPlaylists() {
        List<Playlist> playlists = playlistDao.getPlaylists();

        return playlists.stream().map(ResPlaylistDto::new).collect(Collectors.toList());
    }

    public void postPlaylist(ReqPlaylistDto reqPlaylistDto) {
        playlistDao.postPlaylist(reqPlaylistDto.getUserId(), reqPlaylistDto.getTitle());
    }

    public ResPlaylistDto getPlaylist(Long id) {
        return new ResPlaylistDto(playlistDao.getPlaylist(id));
    }

    public void patchPlaylist(Long id, ReqPlaylistDto reqPlaylistDto) {
        playlistDao.patchPlaylist(id, reqPlaylistDto.getTitle());
    }

    public void deletePlaylist(Long id) {
        playlistDao.deletePlaylist(id);
    }
}
