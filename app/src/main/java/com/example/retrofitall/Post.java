package com.example.retrofitall;

public class Post {

    String userId,id,title,body;

    public String getUserId() {
        return userId;
    }

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
