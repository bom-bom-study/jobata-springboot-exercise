package com.jobata.springbootexercise.dao;

import com.jobata.springbootexercise.domain.Playlist;
import com.jobata.springbootexercise.dto.PlaylistDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistDao {
    private final JdbcTemplate jdbcTemplate;

    public PlaylistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Playlist> getPlaylists() {
        return jdbcTemplate.query("SELECT * FROM playlists", ((rs, rowNum) -> new Playlist(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"))));
    }

    public int postPlaylist(PlaylistDto playlistDto) {
        return jdbcTemplate.update("INSERT INTO playlists(user_id, title) VALUES(?, ?)", playlistDto.getUserId(), playlistDto.getTitle());
    }

    public Playlist getPlaylist(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM playlists WHERE id=?", ((rs, rowNum) -> new Playlist(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"))), id);
    }

    public int patchPlaylist(Long id, PlaylistDto playlistDto) {
        return jdbcTemplate.update("UPDATE playlists SET title=? WHERE id=?", playlistDto.getTitle(), id);
    }

    public int deletePlaylist(Long id) {
        return jdbcTemplate.update("DELETE FROM playlists WHERE id=?", id);
    }
}
