package com.zyzak.blog.dao;

import com.zyzak.blog.mapper.User_postMapper;
import com.zyzak.blog.models.Post;
import com.zyzak.blog.models.Userpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User_postDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public User_postDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Userpost> user_post(){
        String sql = "SELECT * FROM BLOGUSERMVC.\"User_post\"";
        return jdbcTemplate.query(sql, new User_postMapper());
    }

    public Userpost getById(int id){
        String sql = "SELECT * FROM BLOGUSERMVC.\"User_post\" WHERE user_post_id = ?";
        return jdbcTemplate.queryForObject(sql, new User_postMapper(), id);
    }

    public void add(int user_id, int post_id){
        String sql = "INSERT INTO BLOGUSERMVC.\"User_post\" (user_id,post_id) VALUES(?,?)";
        jdbcTemplate.update(sql, user_id, post_id);
    }
}
