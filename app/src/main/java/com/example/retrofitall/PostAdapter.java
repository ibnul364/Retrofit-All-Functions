package com.example.retrofitall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    List<Post> postList;
    Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.postList = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.singleformat,parent,false);

        return new PostViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.id.setText("id : "+post.getId());
        holder.userId.setText("userId: "+post.getUserId());
        holder.title.setText("title : "+post.getTitle());
        holder.body.setText("body : "+post.getBody());

    }


    @Override
    public int getItemCount() {
        return postList.size();
    }



}
