package com.zyzak.blog.dao;

import com.zyzak.blog.mapper.CommentMapper;
import com.zyzak.blog.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDAO {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> comments(){
        String sql = "SELECT * FROM BLOGUSER.\"Comments\"";
        return jdbcTemplate.query(sql, new CommentMapper());
    }

    public Comment getById(int id){
        String sql = "SELECT * FROM BLOGUSER.\"Comments\" WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, new CommentMapper(), id);
    }
}
