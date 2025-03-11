package com.example.testproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.adapter.PostAdapter
import com.example.testproject.repository.PostRepository
import com.example.testproject.utils.SharedPrefManager


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val sharedPrefManager=SharedPrefManager(this)
       // val repository=PostRepository(sharefPreferenceManager)
        viewModel=MainViewModel(this)


        viewModel = MainViewModel(this)
        viewModel.fetchPosts()

        val adapter = viewModel.savedPosts?.let { PostAdapter(it) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }





}