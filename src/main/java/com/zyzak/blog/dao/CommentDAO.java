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
        String sql = "SELECT * FROM BLOGUSERMVC.\"Comments\"";
        return jdbcTemplate.query(sql, new CommentMapper());
    }

    public Comment getById(int id){
        String sql = "SELECT * FROM BLOGUSERMVC.\"Comments\" WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, new CommentMapper(), id);
    }

    public void addComm(Comment comm, int user_id){
        String sql = "INSERT INTO BLOGUSERMVC.\"Comments\" (comment_text,user_id,post_id) VALUES(?,?,?)";
        /*System.out.println("////////////");
        System.out.println(comm.getComment_text());
        System.out.println(user_id);
        System.out.println(comm.getPost_id());*/
        jdbcTemplate.update(sql,comm.getComment_text(), user_id, comm.getPost_id());
    }
}
