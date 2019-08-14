package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofit.model.GithubRepoModel;
import com.example.retrofit.network.GitHubClient;
import com.example.retrofit.network.RetrofitInstance;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       imageView = findViewById(R.id.imageView_avatar);

        GitHubClient gitHubClient = RetrofitInstance.getRetroFitInstance().create(GitHubClient.class);

       Call<List<GithubRepoModel>> call = gitHubClient.getRepos("emhankombo");

       call.enqueue(new Callback<List<GithubRepoModel>>() {
           @Override
           public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {
              List<GithubRepoModel> repos =response.body();




               if (repos != null) {
                   for (int i = 0;i < repos.size();i++){
                       Log.i("MainActivity", "onResponse: " + repos.get(i).getFullName());

                   }
               }
           }

           @Override
           public void onFailure(Call<List<GithubRepoModel>> call, Throwable t) {

           }
       });

    }


}
