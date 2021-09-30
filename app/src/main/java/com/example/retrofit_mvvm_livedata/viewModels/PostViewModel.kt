package com.example.retrofit_mvvm_livedata.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_mvvm_livedata.models.Posts
import com.example.retrofit_mvvm_livedata.repository.BlogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel( private val repository: BlogRepository):ViewModel() {

    val postList : LiveData<List<Posts>>
    get() = repository.post


    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getPostFromServer();
        }
    }
}