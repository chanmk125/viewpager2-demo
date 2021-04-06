package com.example.viewpagerdemo.data.source.local

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource

class LocalDataSource(
    private val repo: RepoDao
): GitHubDataSource {

    override suspend fun getReposByUsername(): Result<GitHubRepo> {
        TODO("Not yet implemented")
    }

}