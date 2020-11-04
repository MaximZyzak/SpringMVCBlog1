package com.zyzak.blog.models;

public class Userpost {

    private int user_post_id;
    private int user_id;
    private int post_id;

    public Userpost(int user_post_id, int user_id, int post_id) {
        this.user_post_id = user_post_id;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public Userpost() {
    }

    public int getUser_post_id() {
        return user_post_id;
    }

    public void setUser_post_id(int user_post_id) {
        this.user_post_id = user_post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
