package com.example.viewpagerdemo.data.model

import com.squareup.moshi.Json

class GitHubRepo (
    val owner: GitHubOwner,
    @Json(name = "name")
    val repoName: String,
    @Json(name = "html_url")
    val url: String,
    @Json(name = "stargazers_count")
    val star: String
)