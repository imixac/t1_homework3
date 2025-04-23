package ru.t1.Homework3.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUserTable() {
        jdbcTemplate
                .execute("CREATE TABLE users (id BIGSERIAL PRIMARY KEY, username VARCHAR (255) UNIQUE NOT NULL);");
    }

    public void deleteUserTable() {
        jdbcTemplate.execute("DROP TABLE users;");
    }

    public void insertUser(String name) {
        jdbcTemplate.update("INSERT INTO users (id, username) VALUES (DEFAULT, \'"+name+"\')");
    }

    public void deleteUser(String name) {
        jdbcTemplate.execute("DELETE FROM users WHERE username = '"+name+"';");
    }

    public User getUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id, username FROM users WHERE id = "+id+";",
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username")));
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT id, username FROM users;",
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username")));
    }
}
