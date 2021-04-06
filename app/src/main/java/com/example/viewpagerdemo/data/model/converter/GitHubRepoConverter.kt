package com.example.viewpagerdemo.data.model.converter

import androidx.room.TypeConverter
import com.example.viewpagerdemo.data.model.GitHubOwner
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class GitHubRepoConverter {
    @TypeConverter
    fun ownerToString(owner: GitHubOwner): String {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val parser = moshi.adapter(GitHubOwner::class.java)
        return parser.toJson(owner)
    }

    @TypeConverter
    fun stringToOwner(strOwner: String): GitHubOwner? {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val parser = moshi.adapter(GitHubOwner::class.java)
        return parser.fromJson(strOwner)
    }
}