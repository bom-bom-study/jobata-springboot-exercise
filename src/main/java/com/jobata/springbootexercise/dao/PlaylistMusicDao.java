package com.jobata.springbootexercise.dao;

import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.PlaylistMusicDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistMusicDao {
    private final JdbcTemplate jdbcTemplate;

    public PlaylistMusicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int postPlaylistMusic(Long id, PlaylistMusicDto playlistMusicDto) {
        return jdbcTemplate.update("INSERT INTO playlist_music_list(playlist_id, music_id) VALUES(?, ?)", id, playlistMusicDto.getMusicId());
    }

    public List<Music> getPlaylistMusics(Long id) {
        return jdbcTemplate.query("SELECT id, title, singer FROM musics JOIN playlist_music_list ON musics.id=playlist_music_list.music_id WHERE playlist_music_list.playlist_id=?", ((rs, rowNum) -> new Music(rs.getLong("id"), rs.getString("title"), rs.getString("singer"))), id);
    }

    public int deletePlaylistMusic(Long playlistId, Long musicId) {
        return jdbcTemplate.update("DELETE FROM playlist_music_list WHERE playlist_id=? AND music_id=?", playlistId, musicId);
    }
}
