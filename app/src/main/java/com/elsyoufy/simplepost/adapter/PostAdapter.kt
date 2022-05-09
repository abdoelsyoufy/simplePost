package com.elsyoufy.simplepost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elsyoufy.simplepost.R
import com.elsyoufy.simplepost.databinding.PostItemDesignBinding
import com.elsyoufy.simplepost.model.Post

class PostAdapter() : RecyclerView.Adapter<PostAdapter.PostViewHodler>() {

    private var posts: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHodler {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_design, parent, false)
        return PostViewHodler(view)
    }


    override fun onBindViewHolder(holder: PostViewHodler, position: Int) {
        val post = posts?.get(position)
        holder.binding.post = post
    }


    override fun getItemCount(): Int = posts.size
    fun setList(list: List<Post>) {
        posts = list
    }

    inner class PostViewHodler(view: View) : RecyclerView.ViewHolder(view) {
        val binding = PostItemDesignBinding.bind(view)
    }

}