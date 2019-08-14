package com.example.retrofit.network;

import com.example.retrofit.model.GithubRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GithubRepoModel>> getRepos(@Path("user") String user);



}
