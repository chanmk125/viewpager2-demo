package com.example.viewpagerdemo.data.source

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result

interface GitHubDataSource {

    suspend fun getReposByUsername(): Result<List<GitHubRepo>>

    suspend fun saveRepos(list: List<GitHubRepo>)

    suspend fun deleteAllRepose()
}