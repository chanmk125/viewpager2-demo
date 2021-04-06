package com.example.viewpagerdemo.repository

import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.result.Result

interface GitHubRepository {

    suspend fun getReposByUsername(): Result<GitHubRepo>
}