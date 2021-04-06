package com.example.viewpagerdemo.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.viewpagerdemo.data.model.GitHubRepo

@Database(entities = [GitHubRepo::class], version = 1)
abstract class GitHubDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}