package com.example.tracks.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("User_Id")
    private int user_Id;
    @SerializedName("Id")
    private int Id;
    @SerializedName("Title")
    private String title;
    @SerializedName("Body")
    private String body;

    public Post(int user_Id, int id, String title, String body) {
        this.user_Id = user_Id;
        Id = id;
        this.title = title;
        this.body = body;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
