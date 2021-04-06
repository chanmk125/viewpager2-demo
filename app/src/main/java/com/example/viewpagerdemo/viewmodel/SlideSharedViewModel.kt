package com.example.viewpagerdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerdemo.repository.GitHubRepository
import kotlinx.coroutines.launch

class SlideSharedViewModel(
    private val gitHubRepository: GitHubRepository
) : ViewModel() {

    // expose shared live data

    // expose function to update shared live data


    fun initRepoList() {
        viewModelScope.launch {
            val result = gitHubRepository.getReposByUsername()
            Log.d("viewModel", "result: $result")
        }
    }
}