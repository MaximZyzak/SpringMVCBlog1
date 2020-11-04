package com.zyzak.blog.models;

public class Post {
    private int post_id;
    private String post_text;
    private String title_post;


    public Post(int post_id, String title_post, String post_text) {
        this.post_id = post_id;
        this.post_text = post_text;
        this.title_post = title_post;
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

    public String getTitle_post() {
        return title_post;
    }

    public void setTitle_post(String title_post) {
        this.title_post = title_post;
    }

}
