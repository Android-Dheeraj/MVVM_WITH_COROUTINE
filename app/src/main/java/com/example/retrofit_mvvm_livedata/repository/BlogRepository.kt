package com.example.retrofit_mvvm_livedata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit_mvvm_livedata.apis.BlogApi
import com.example.retrofit_mvvm_livedata.models.Posts

class BlogRepository(private val blogApi: BlogApi ) {

    private val _posts : MutableLiveData<List<Posts>> = MutableLiveData()
    val  post : LiveData<List<Posts>>
    get() = _posts

    suspend fun getPostFromServer(){
      val result =  blogApi.getPost()
        if(result != null) {
         _posts.postValue(result)
        }
    }
}