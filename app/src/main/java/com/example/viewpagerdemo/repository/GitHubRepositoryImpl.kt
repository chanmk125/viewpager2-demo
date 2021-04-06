package com.example.viewpagerdemo.repository

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result

class GitHubRepositoryImpl : GitHubRepository {

    override suspend fun getReposByUsername(): Result<GitHubRepo> {
        TODO("Not yet implemented")
    }

}