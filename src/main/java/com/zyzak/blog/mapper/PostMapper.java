package com.zyzak.blog.mapper;

import com.zyzak.blog.models.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper  implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPost_id(rs.getInt("post_id"));
        post.setTitle_post(rs.getString("title_post"));
        post.setPost_text(rs.getString("post_text"));
        return post;
    }
}
