package com.sanket.assignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sanket.assignment.R
import com.sanket.assignment.adapters.MainAdapters
import com.sanket.assignment.interfaces.ItemClickListener
import com.sanket.assignment.models.response.UserResponse
import com.sanket.assignment.utils.MyUtils
import com.sanket.assignment.utils.NetworkResult
import com.sanket.assignment.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(), ItemClickListener {
    lateinit var recyl: RecyclerView
    lateinit var swiperefresh: SwipeRefreshLayout
    lateinit var mainAdapters: MainAdapters
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        observeViewModel()
    }

    fun init() {
        mainAdapters = MainAdapters(this,this)
        recyl = findViewById(R.id.recyl)
        swiperefresh = findViewById(R.id.swiperefresh)
        swiperefresh.setOnRefreshListener {
            observeViewModel()
            swiperefresh.setRefreshing(false);
        }
        recyl.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            setHasFixedSize(true)
            adapter = mainAdapters
        }
    }

    fun observeViewModel() {
        mainViewModel.getUserList().observe(this, {
            when (it) {
                is NetworkResult.Success -> {
                    mainAdapters.setData(it.data)
                }
                is NetworkResult.Error -> {
                    MyUtils.showErrorLog(it.exception)
                }
            }
        })
    }

    override fun onItemClicked(userResponse: UserResponse) {
        Intent(this, UserDetailActivity::class.java).apply {
            putExtra("obj", userResponse)
            startActivity(this)
        }
    }
}