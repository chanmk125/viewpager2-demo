package com.example.viewpagerdemo.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.viewpagerdemo.data.model.GitHubRepo

@Dao
interface RepoDao {
    @Query("SELECT * FROM github_repos")
    suspend fun getAll(): List<GitHubRepo>

    @Insert
    suspend fun insertAll(repos: List<GitHubRepo>)

    @Delete
    suspend fun delete(repo: GitHubRepo)

    @Query("DELETE FROM github_repos")
    suspend fun deleteAll()
}