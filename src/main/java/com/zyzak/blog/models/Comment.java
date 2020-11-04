package com.zyzak.blog.models;

public class Comment {

    private int comment_id;
    private String comment_text;

    public Comment(int comment_id, String comment_text) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
    }

    public Comment() {
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
}
