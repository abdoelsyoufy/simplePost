package com.elsyoufy.simplepost.networking

import com.elsyoufy.simplepost.model.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    fun getPosts() : Observable<List<Post>>
}