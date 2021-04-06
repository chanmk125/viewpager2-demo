package com.example.viewpagerdemo.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.viewpagerdemo.data.model.GitHubRepo
import com.example.viewpagerdemo.data.model.converter.GitHubRepoConverter

@Database(entities = [GitHubRepo::class], version = 1)
@TypeConverters(GitHubRepoConverter::class)
abstract class GitHubDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}