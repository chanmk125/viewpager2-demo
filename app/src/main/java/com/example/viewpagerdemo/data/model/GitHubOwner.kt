package com.example.viewpagerdemo.data.model

import com.squareup.moshi.Json

data class GitHubOwner(
    val id: String,
    @Json(name = "login")
    val name: String,
    @Json(name = "avatar_url")
    val icon: String
)