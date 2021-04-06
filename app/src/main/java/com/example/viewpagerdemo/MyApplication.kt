package com.example.viewpagerdemo

import android.app.Application
import com.example.viewpagerdemo.di.GitHubContainer

class MyApplication : Application() {

    companion object {
        lateinit var gitHubContainer: GitHubContainer
    }

    override fun onCreate() {
        super.onCreate()
        initContainer()
    }

    private fun initContainer() {
        gitHubContainer = GitHubContainer(applicationContext)
    }
}