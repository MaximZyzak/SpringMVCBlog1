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
        jdbcTemplate.update(sql,comm.getComment_text(), user_id, comm.getPost_id());
    }

    public void deleteComm(int id){
        String sql = "DELETE FROM BLOGUSERMVC.\"Comments\" WHERE comment_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateComm(Comment comm){
        String sql = "UPDATE BLOGUSERMVC.\"Comments\" SET comment_text =?, user_id=?, post_id=? WHERE comment_id = ?";
        jdbcTemplate.update(sql, comm.getComment_text(), comm.getUser_id(), comm.getPost_id(), comm.getComment_id());
    }
}
