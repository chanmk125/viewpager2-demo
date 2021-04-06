package com.example.viewpagerdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SlideSharedViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(SlideSharedViewModel::class.java) -> {
                    SlideSharedViewModel()
                }
                else ->
                    throw IllegalStateException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
    }
}