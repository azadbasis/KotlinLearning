package com.azharul.kotlinlearning.api

import com.azharul.kotlinlearning.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost1(): Post

    //Handle base not found
    @GET("posts/1")
    suspend fun getPost2(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost3(@Path("postNumber") number: Int): Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId:Int,
        @Query("_sort") sort:String,
        @Query("_order") order:String

    ):Response<List<Post>>
    //Multiple query annotation with query map
    @GET("posts")
    suspend fun getCustomPost2(
        @Query("userId") userId: Int,
        @QueryMap option: Map<String, String>
    ):Response<List<Post>>
}