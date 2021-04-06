package com.example.viewpagerdemo.di

import android.content.Context
import androidx.room.Room
import com.example.viewpagerdemo.data.source.remote.RetrofitBuilder
import com.example.viewpagerdemo.data.source.local.GitHubDatabase

/**
 * Container to inject dependencies manually
 */
class GitHubContainer(
    context: Context
) {

    val githubApi by lazy {
        RetrofitBuilder.createGithubApi()
    }

    val database by lazy {
        createDatabase(context)
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