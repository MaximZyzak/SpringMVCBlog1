package com.zyzak.blog.mapper;

import com.zyzak.blog.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setComment_id(rs.getInt("comment_id"));
        comment.setComment_text(rs.getString("comment_text"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setPost_id(rs.getInt("post_id"));
        return comment;
    }
}