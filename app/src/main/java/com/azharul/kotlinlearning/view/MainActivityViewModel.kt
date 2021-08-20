package com.azharul.kotlinlearning.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azharul.kotlinlearning.model.Post
import com.azharul.kotlinlearning.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    val myResponse1: MutableLiveData<Post> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse4: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse1.value = response
        }
    }

    fun getPost2() {
        viewModelScope.launch {
            val response = repository.getPost2()
            myResponse2.value = response
        }
    }
    fun getPost3(number:Int) {
        viewModelScope.launch {
            val response = repository.getPost3(number)
            myResponse3.value = response
        }
    }
    fun getCustomPosts(userId:Int,sort:String, order:String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId,sort,order)
            myResponse4.value = response
        }
    }
    fun getCustomPosts2(userId:Int,option:Map<String,String>) {
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId,option)
            myResponse4.value = response
        }
    }
}