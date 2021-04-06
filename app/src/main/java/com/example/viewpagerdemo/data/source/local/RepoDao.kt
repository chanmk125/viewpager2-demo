package com.example.viewpagerdemo.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.viewpagerdemo.data.model.GitHubRepo

@Dao
interface RepoDao {
    @Query("SELECT * FROM github_repos")
    fun getAll(): List<GitHubRepo>

    @Insert
    fun insertAll(repos: List<GitHubRepo>)

    @Delete
    fun delete(repo: GitHubRepo)
}