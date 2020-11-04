package com.zyzak.blog.dao;



import com.zyzak.blog.mapper.UserMapper;
import com.zyzak.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> users(){
        String sql = "SELECT * FROM BLOGUSER.\"Users\"";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public User getById(int id){
        String sql = "SELECT * FROM BLOGUSER.\"Users\" WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }
}
