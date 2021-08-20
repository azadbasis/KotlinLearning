package com.azharul.kotlinlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azharul.kotlinlearning.R
import com.azharul.kotlinlearning.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var posAdapter: PostRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
//            withoutHandleBase()
//            handleBase()
//            getPostsWithPath(muNumber)
//            getPostsWithQuery(muNumber)
            getPostsWithQueryMap("3")

    }

    fun initRecyclerView() {
        recyclerview.apply {
            recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
            posAdapter = PostRecyclerViewAdapter()
            adapter=posAdapter
        }

    }

    private fun getPostsWithQueryMap(muNumber: String) {
        var options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        viewModel.getCustomPosts2(Integer.parseInt(muNumber), options)
        viewModel.myResponse4.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { posAdapter.submitPostData(it) }
                    Log.d(TAG, "____________________getPostsWithQuery:__________________ ")
                }
             else {
                Log.d(TAG, "onCreate: " + response.errorBody().toString())
            }
        })

    }

    private fun getPostsWithQuery(muNumber: String) {
        viewModel.getCustomPosts(Integer.parseInt(muNumber), "id", "desc")
        viewModel.myResponse4.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.forEach {
                    Log.d(TAG, "getPostsWithQuery: " + it.userId.toString())
                    Log.d(TAG, "getPostsWithQuery: " + it.id.toString())
                    Log.d(TAG, "getPostsWithQuery: " + it.title)
                    Log.d(TAG, "getPostsWithQuery: " + it.body)
                    Log.d(TAG, "____________________getPostsWithQuery:__________________ ")
                }
            } else {
                Log.d(TAG, "onCreate: " + response.errorBody().toString())
            }
        })
    }

    private fun getPostsWithPath(muNumber: String) {
        viewModel.getPost3(Integer.parseInt(muNumber))
        viewModel.myResponse3.observe(this, Observer { response ->
            if (response.isSuccessful) {
            } else {
                Log.d(TAG, "onCreate: " + response.errorBody().toString())
            }
        })
    }

    private fun withoutHandleBase() {
        viewModel.getPost()
        viewModel.myResponse1.observe(this, Observer { response ->
            Log.d(TAG, "onCreate: " + response.userId.toString())
            Log.d(TAG, "onCreate: " + response.id.toString())
            Log.d(TAG, "onCreate: " + response.title)
            Log.d(TAG, "onCreate: " + response.body)
        })
    }

    private fun handleBase() {
        viewModel.getPost2()
        viewModel.myResponse2.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d(TAG, "onCreate: " + response.body()?.userId.toString())
                Log.d(TAG, "onCreate: " + response.body()?.id.toString())
                Log.d(TAG, "onCreate: " + response.body()?.title!!)
                Log.d(TAG, "onCreate: " + response.body()?.body!!)
            } else {
                Log.d(TAG, "onCreate: " + response.errorBody().toString())
            }
        })
    }
}