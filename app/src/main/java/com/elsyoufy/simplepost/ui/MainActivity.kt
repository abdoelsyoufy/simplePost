package com.elsyoufy.simplepost.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elsyoufy.simplepost.R
import com.elsyoufy.simplepost.adapter.PostAdapter
import com.elsyoufy.simplepost.databinding.ActivityMainBinding
import com.elsyoufy.simplepost.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {
    val binding :  ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    lateinit var madapter : PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        madapter = PostAdapter()
        viewModel.get_Posts()
        viewModel.posts.observe(this) {
            madapter.setList(it)
        }
        binding.mainRv.apply {
            adapter = madapter
            hasFixedSize()
        }

    }
}