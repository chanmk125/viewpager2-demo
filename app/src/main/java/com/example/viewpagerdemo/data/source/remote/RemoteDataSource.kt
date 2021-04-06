package com.example.viewpagerdemo.data.source.remote

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource
import com.example.viewpagerdemo.data.source.remote.api.GitHubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource(
    private val gitHubApi: GitHubApi
) : GitHubDataSource {

    override suspend fun getReposByUsername(): Result<List<GitHubRepo>> {
        return withContext(Dispatchers.IO) {
            val response = gitHubApi.getGithubRepos("mrky125", 1, 3)
            if (response.isSuccessful) {
                Result.Success(response.body())
            } else {
                Result.Failure(response.code(), null)
            }
        }
    }

}