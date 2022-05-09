package com.elsyoufy.simplepost.networking

import com.elsyoufy.simplepost.model.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val baseURL = "https://jsonplaceholder.typicode.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val apiService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
    fun getPosts() : Observable<List<Post>> = apiService.getPosts()






}