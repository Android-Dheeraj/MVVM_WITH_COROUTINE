package com.example.retrofit_mvvm_livedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_mvvm_livedata.databinding.PostViewHolderBinding
import com.example.retrofit_mvvm_livedata.models.Posts

class PostViewAdapter(private  val postList: List<Posts>): RecyclerView.Adapter<PostViewAdapter.PostViewHolder>() {

    class PostViewHolder (val binding: PostViewHolderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostViewHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.postTiltle.text = postList[position].title
        holder.binding.postDescription.text = postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}