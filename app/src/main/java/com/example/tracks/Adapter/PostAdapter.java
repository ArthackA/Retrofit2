package com.example.tracks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tracks.MainActivity;
import com.example.tracks.R;
import com.example.tracks.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private Context mContext;
    private List<Post> mPost;


    public PostAdapter(Context mContext, List<Post> mPost) {
        this.mContext = mContext;
        this.mPost = mPost;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_list,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post posts= mPost.get(position);

        holder.mUserId.setText(Integer.toString(posts.getUser_Id()));
        holder.mPostId.setText(Integer.toString(posts.getId()));
        holder.mTitle.setText(posts.getTitle());
        holder.mBody.setText(posts.getBody());



    }

    @Override
    public int getItemCount() {
        return mPost.size();
    }

     class  PostViewHolder extends RecyclerView.ViewHolder{
        TextView mUserId,mPostId,mBody,mTitle;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            mUserId= itemView.findViewById(R.id.user_Id);
            mPostId= itemView.findViewById(R.id.post_Id);
            mBody=itemView.findViewById(R.id.post_body);
            mTitle=itemView.findViewById(R.id.post_title);
        }
    }
}
