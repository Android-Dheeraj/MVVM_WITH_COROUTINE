package com.example.retrofit_mvvm_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_mvvm_livedata.adapters.PostViewAdapter
import com.example.retrofit_mvvm_livedata.apis.BlogApi
import com.example.retrofit_mvvm_livedata.databinding.ActivityMainBinding
import com.example.retrofit_mvvm_livedata.models.Posts
import com.example.retrofit_mvvm_livedata.repository.BlogRepository
import com.example.retrofit_mvvm_livedata.retrofit.RetrofitInstance
import com.example.retrofit_mvvm_livedata.viewModels.PostViewModel
import com.example.retrofit_mvvm_livedata.viewModels.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var adapter: PostViewAdapter
    private var blogPost = mutableListOf<Posts>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val blogApi = RetrofitInstance.retrofit.create(BlogApi::class.java)
        val repository = BlogRepository(blogApi)
        adapter = PostViewAdapter(blogPost)
        viewModel = ViewModelProvider(this,PostViewModelFactory(repository)).get(PostViewModel::class.java)
        viewModel.postList.observe(this,{ posts ->
            blogPost.addAll(posts)
            adapter.notifyDataSetChanged()

        })
        binding.postList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.postList.adapter = adapter
    }
}