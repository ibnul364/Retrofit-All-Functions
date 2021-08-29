package com.example.retrofitall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder>{

    Context context;
    List<Comment> commentList;


    public CommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_comment,parent,false);

        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {

        Comment comment = commentList.get(position);
        holder.postId.setText("postId : "+comment.getPostId());
        holder.id.setText("id : "+comment.getId());
        holder.commentText.setText("commentText : "+comment.getCommentText());
        holder.name.setText("name : "+comment.getName());
        holder.email.setText("email : "+comment.getEmail());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }











    public class CommentHolder extends RecyclerView.ViewHolder {

        TextView postId, id, email,name, commentText;



        public CommentHolder(@NonNull View itemView) {
            super(itemView);


            postId = itemView.findViewById(R.id.post_id);
            id = itemView.findViewById(R.id.comment_id);
            email = itemView.findViewById(R.id.comment_email);
            name = itemView.findViewById(R.id.user_name);
            commentText = itemView.findViewById(R.id.comment_text);
        }
    }





}
