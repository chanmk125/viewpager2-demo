package com.example.viewpagerdemo.data.source.local

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result
import com.example.viewpagerdemo.data.source.GitHubDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val repoDao: RepoDao
): GitHubDataSource {

    override suspend fun getReposByUsername(): Result<List<GitHubRepo>> {
        return try {
            withContext(Dispatchers.IO) {
                Result.Success(repoDao.getAll())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun saveRepos(list: List<GitHubRepo>) {
        withContext(Dispatchers.IO) {
            repoDao.insertAll(list)
        }
    }

    override suspend fun deleteAllRepose() {
        withContext(Dispatchers.IO) {
            repoDao.deleteAll()
        }
    }

}