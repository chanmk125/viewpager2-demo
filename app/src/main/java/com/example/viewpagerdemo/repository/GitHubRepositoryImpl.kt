package com.example.viewpagerdemo.repository

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource

class GitHubRepositoryImpl(
    private val remoteDataSource: GitHubDataSource,
    private val localDataSource: GitHubDataSource
) : GitHubRepository {

    override suspend fun getReposByUsername(): Result<List<GitHubRepo>> {
        return remoteDataSource.getReposByUsername()
    }

}