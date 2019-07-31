package com.example.tracks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tracks.Adapter.PostAdapter;
import com.example.tracks.model.Post;
import com.example.tracks.network.Api;
import com.example.tracks.network.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<Post> mPost;
    PostAdapter mAdapter;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.post_recycler_View);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPosts();
    }

    private void loadPosts() {
//        mDialog.setMessage("Fetching posts....");
//        mDialog.show();
        Api api= Service.getService();
        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    mPost=response.body();
                    mPost = new ArrayList<>();
//                    mDialog.dismiss();
                    for(Post post:mPost){
                        String content="";
                        content+=post.getBody();
                        content+=post.getTitle();

                    }
                }else{
//                    mDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Connection problema try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
