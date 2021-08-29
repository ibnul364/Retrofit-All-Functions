package com.example.retrofitall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    JSONPlaceholder jsonPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycerlview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl("https://jsonplaceholder.typicode.com/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();

         jsonPlaceholder = retrofit.create(JSONPlaceholder.class);

//            getPost();
            getComments();

    }


    //First Attempt
    public void getPost() {


        Call<List<Post>> call = jsonPlaceholder.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> postList = response.body();
                PostAdapter postAdapter = new PostAdapter(postList, MainActivity.this);
                recyclerView.setAdapter(postAdapter);

//                    Log.d("@@",""+postAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


        //2nd Attempt
    public void getComments() {


        Call<List<Comment>> call = jsonPlaceholder.getComments();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Comment> comments = response.body();
                CommentAdapter commentAdapter = new CommentAdapter(MainActivity.this,comments);
                recyclerView.setAdapter(commentAdapter);

//                    Log.d("@@",""+commentAdapter);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }



}