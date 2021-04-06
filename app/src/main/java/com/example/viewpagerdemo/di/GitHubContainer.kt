package com.example.viewpagerdemo.di

import android.content.Context
import androidx.room.Room
import com.example.viewpagerdemo.data.source.remote.RetrofitBuilder
import com.example.viewpagerdemo.data.source.local.GitHubDatabase
import com.example.viewpagerdemo.data.source.local.LocalDataSource
import com.example.viewpagerdemo.data.source.remote.RemoteDataSource
import com.example.viewpagerdemo.repository.GitHubRepositoryImpl

/**
 * Container to inject dependencies manually
 */
class GitHubContainer(
    context: Context
) {

    private val githubApi by lazy {
        RetrofitBuilder.createGithubApi()
    }

    private val database by lazy {
        createDatabase(context)
    }

    val githubRepository by lazy {
        val remoteDataSource = RemoteDataSource(githubApi)
        val localDataSource = LocalDataSource(database.repoDao())
        GitHubRepositoryImpl(remoteDataSource, localDataSource)
    }

    private fun createDatabase(context: Context): GitHubDatabase {
        return Room.databaseBuilder(
            context,
            GitHubDatabase::class.java,
            DB_NAME
        ).build()
    }

    companion object {
        private const val DB_NAME = "github_database"
    }
}