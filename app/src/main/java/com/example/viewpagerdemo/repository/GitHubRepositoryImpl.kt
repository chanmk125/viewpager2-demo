package com.example.viewpagerdemo.repository

import android.util.Log
import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource

class GitHubRepositoryImpl(
    private val remoteDataSource: GitHubDataSource,
    private val localDataSource: GitHubDataSource
) : GitHubRepository {

    override suspend fun getReposByUsername(): Result<List<GitHubRepo>> {
        val forceUpdate = true // fake value
        if (forceUpdate) {
            try {
                updateLocalRepos()
            } catch (e: Exception) {
                return Result.Error(e)
            }
        }
        Log.d("repository", "succeeded to update local db")
        return remoteDataSource.getReposByUsername()
    }

    private suspend fun updateLocalRepos() {
        val remoteRepos = remoteDataSource.getReposByUsername()
        Log.d("repository", "fetched value: $remoteRepos")
        if (remoteRepos is Result.Success) {
            remoteRepos.data?.forEach {
                Log.d("repository", "item id: ${it.id}, name: ${it.repoName}, url: ${it.url}")
            }
            localDataSource.deleteAllRepose()
            Log.d("repository", "succeeded to delete all")
            remoteRepos.data?.let { repos ->
                localDataSource.saveRepos(repos)
                Log.d("repository", "succeeded to save all")
            }
        } else {
            throw Exception("failed to fetch")
        }
    }

}