package com.example.viewpagerdemo.di

import com.example.viewpagerdemo.data.RetrofitBuilder

/**
 * Container to inject dependencies manually
 */
class GitHubContainer {

    val githubApi by lazy {
        RetrofitBuilder.createGithubApi()
    }
}