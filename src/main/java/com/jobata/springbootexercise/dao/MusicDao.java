package com.jobata.springbootexercise.dao;

import com.jobata.springbootexercise.domain.Music;
import com.jobata.springbootexercise.dto.MusicDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicDao {
    private final JdbcTemplate jdbcTemplate;

    public MusicDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Music> getMusics() {
        return jdbcTemplate.query("SELECT * FROM musics", ((rs, rowNum) -> new Music(rs.getLong("id"), rs.getString("title"), rs.getString("singer"))));
    }

    public int postMusic(MusicDto musicDto) {
        return jdbcTemplate.update("INSERT INTO musics(title, singer) VALUES(?, ?)", musicDto.getTitle(), musicDto.getSinger());
    }

    public Music getMusic(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM musics WHERE id=?", ((rs, rowNum) -> new Music(rs.getLong("id"), rs.getString("title"), rs.getString("singer"))), id);
    }

    public int patchMusic(Long id, MusicDto musicDto) {
        return jdbcTemplate.update("UPDATE musics SET title=?, singer=? WHERE id=?", musicDto.getTitle(), musicDto.getSinger(), id);
    }

    public int deleteMusic(Long id) {
        return jdbcTemplate.update("DELETE FROM musics WHERE id=?", id);
    }
}
