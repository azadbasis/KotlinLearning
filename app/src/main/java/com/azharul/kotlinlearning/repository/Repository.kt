package com.azharul.kotlinlearning.repository

import com.azharul.kotlinlearning.model.Post
import com.azharul.kotlinlearning.api.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost1()
    }
    suspend fun getPost2(): Response<Post> {
        return RetrofitInstance.api.getPost2()
    }
    suspend fun getPost3(number:Int): Response<Post> {
        return RetrofitInstance.api.getPost3(number)
    }
    suspend fun getCustomPosts(userId:Int,sort:String,order:String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }
    suspend fun getCustomPosts2(userId:Int,option:Map<String,String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId,option)
    }
}