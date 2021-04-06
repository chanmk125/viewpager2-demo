package com.example.viewpagerdemo.data.source.remote

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource

class RemoteDataSource : GitHubDataSource {

    override suspend fun getReposByUsername(): Result<GitHubRepo> {
        TODO("Not yet implemented")
    }

}