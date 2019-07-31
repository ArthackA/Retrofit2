package com.example.tracks.network;

import com.example.tracks.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Call<List<Post>>getPosts();
}
