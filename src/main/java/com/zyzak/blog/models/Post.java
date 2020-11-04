package com.zyzak.blog.models;

public class Post {
    private int post_id;
    private String post_text;
    private int comment_id;

    public Post(int post_id, String post_text, int comment_id) {
        this.post_id = post_id;
        this.post_text = post_text;
        this.comment_id = comment_id;
    }

    public Post() {
    }


    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }


}
