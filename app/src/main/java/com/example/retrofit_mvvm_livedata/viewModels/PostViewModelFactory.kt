package com.example.retrofit_mvvm_livedata.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit_mvvm_livedata.repository.BlogRepository

class PostViewModelFactory(private val repository: BlogRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  PostViewModel(repository = repository) as T
    }
}