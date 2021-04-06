package com.example.viewpagerdemo.data.source.remote.api

import com.example.viewpagerdemo.data.model.GitHubOwner
import com.example.viewpagerdemo.data.model.GitHubRepo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("/users/{username}/repos")
    suspend fun getGithubRepos(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<GitHubRepo>>

    @GET("/users/{username}")
    suspend fun getGithubOwner(@Path("username") username: String): Response<GitHubOwner>
}