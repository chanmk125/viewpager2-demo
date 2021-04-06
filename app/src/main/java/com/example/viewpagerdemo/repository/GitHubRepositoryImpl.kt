package com.example.viewpagerdemo.repository

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource

class GitHubRepositoryImpl(
    private val remoteDataSource: GitHubDataSource,
    private val localDataSource: GitHubDataSource
) : GitHubRepository {

    override suspend fun getReposByUsername(): Result<List<GitHubRepo>> {
        val forceUpdate = false // fake value
        if (forceUpdate) {
            // Never pass here until implement updateLocalRepos()
            updateLocalRepos()
        }

        return remoteDataSource.getReposByUsername()
    }

    private suspend fun updateLocalRepos() {
        val remoteRepos = remoteDataSource.getReposByUsername()
        if (remoteRepos is Result.Success) {
            // TODO: delete local and insert all
        } else {
            throw Exception("failed to fetch")
        }
    }

}