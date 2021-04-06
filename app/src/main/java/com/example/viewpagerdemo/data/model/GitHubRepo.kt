package com.example.viewpagerdemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "github_repos")
class GitHubRepo(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "owner")
    val owner: GitHubOwner,

    @ColumnInfo(name = "repo_name")
    @Json(name = "name")
    val repoName: String,

    @ColumnInfo(name = "html_url")
    @Json(name = "html_url")
    val url: String,

    @ColumnInfo(name = "stargazers_count")
    @Json(name = "stargazers_count")
    val star: String
)