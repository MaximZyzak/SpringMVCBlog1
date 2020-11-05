package com.zyzak.blog.dao;

import com.zyzak.blog.mapper.PostMapper;
import com.zyzak.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> posts(){
        String sql = "SELECT * FROM BLOGUSERMVC.\"Posts\"";
        return jdbcTemplate.query(sql, new PostMapper());
    }

    public Post getById(int id){
        String sql = "SELECT * FROM BLOGUSERMVC.\"Posts\" WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, new PostMapper(), id);
    }

    public void update(Post post){
        String sql = "UPDATE BLOGUSERMVC.\"Posts\" SET title_post =?, post_text=? WHERE post_id = ?";
        jdbcTemplate.update(sql, post.getTitle_post(), post.getPost_text(), post.getPost_id());
    }

    public void add(Post post){
        String sql = "INSERT INTO BLOGUSERMVC.\"Posts\" (title_post,post_text) VALUES(?,?)";
        jdbcTemplate.update(sql, post.getTitle_post(), post.getPost_text());
    }

    public void delete(int id){
        String sql = "DELETE FROM BLOGUSERMVC.\"Posts\" WHERE post_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Post getPostLastId(){
        String sql = "SELECT * FROM BLOGUSERMVC.\"Posts\" WHERE post_id = (SELECT MAX(post_id) FROM BLOGUSERMVC.\"Posts\")";
        return jdbcTemplate.queryForObject(sql, new PostMapper());
    }
}
