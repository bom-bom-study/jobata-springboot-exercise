package com.jobata.springbootexercise.dao;

import com.jobata.springbootexercise.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", ((rs, rowNum) -> new User(rs.getLong("id"), rs.getString("nickname"))));
    }

    public int postUser(String nickname) {
        return jdbcTemplate.update("INSERT INTO users(nickname) VALUES(?)", nickname);
    }

    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", ((rs, rowNum) -> new User(rs.getLong("id"), rs.getString("nickname"))), id);
    }

    public int patchUser(Long id, String nickname) {
        return jdbcTemplate.update("UPDATE users SET nickname=? WHERE id=?", nickname, id);
    }

    public int deleteUser(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
