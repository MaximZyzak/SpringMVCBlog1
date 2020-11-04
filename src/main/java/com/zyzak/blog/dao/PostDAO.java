package com.zyzak.blog.dao;

import com.zyzak.blog.mapper.PostMapper;
import com.zyzak.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> posts(){
        String sql = "SELECT * FROM BLOGUSER1.\"Posts\"";
        return jdbcTemplate.query(sql, new PostMapper());
    }

    public Post getById(int id){
        String sql = "SELECT * FROM BLOGUSER1.\"Posts\" WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, new PostMapper(), id);
    }

    public void update(Post post){
        String sql = "UPDATE BLOGUSER1.\"Posts\" SET post_text=? WHERE post_id = ?";
        jdbcTemplate.update(sql, post.getPost_text(), post.getPost_id());
    }

    public void add(Post post){
        String sql = "INSERT INTO BLOGUSER1.\"Posts\" (post_text) VALUES(?)";
        jdbcTemplate.update(sql, post.getPost_text());
    }

    public void delete(int id){
        String sql = "DELETE FROM BLOGUSER1.\"Posts\" WHERE post_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
