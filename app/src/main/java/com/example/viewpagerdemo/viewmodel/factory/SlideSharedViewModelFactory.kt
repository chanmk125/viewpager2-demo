package com.example.viewpagerdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerdemo.repository.GitHubRepository
import com.example.viewpagerdemo.viewmodel.SlideSharedViewModel

class SlideSharedViewModelFactory(
    private val gitHubRepository: GitHubRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(SlideSharedViewModel::class.java) -> {
                    SlideSharedViewModel(gitHubRepository)
                }
                else ->
                    throw IllegalStateException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}