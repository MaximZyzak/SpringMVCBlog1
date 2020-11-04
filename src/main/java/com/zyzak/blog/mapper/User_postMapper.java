package com.zyzak.blog.mapper;

import com.zyzak.blog.models.Userpost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User_postMapper implements RowMapper<Userpost> {
    @Override
    public Userpost mapRow(ResultSet rs, int rowNum) throws SQLException {
        Userpost userpost = new Userpost();
        userpost.setUser_post_id(rs.getInt("user_post_id"));
        userpost.setUser_id(rs.getInt("user_id"));
        userpost.setPost_id(rs.getInt("post_id"));
        return userpost;
    }
}