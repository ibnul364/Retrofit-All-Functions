package com.example.retrofitall;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView title,id,body,userId;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        title=itemView.findViewById(R.id.title_tv);
        id=itemView.findViewById(R.id.id_tv);
        body=itemView.findViewById(R.id.body_tv);
        userId=itemView.findViewById(R.id.user_id_tv);


    }



}
