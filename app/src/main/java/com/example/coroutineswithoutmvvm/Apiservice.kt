package com.example.coroutineswithoutmvvm

import retrofit2.Response
import retrofit2.http.GET

interface Apiservice {
@GET("posts")
suspend fun getAllPosts() : Response<List<PostModel>>
}