package com.elsyoufy.simplepost.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elsyoufy.simplepost.model.Post
import com.elsyoufy.simplepost.networking.API
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private  val TAG = "MainViewModel"

    private val _Posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = _Posts


    init {
       // get_Posts()
    }

     fun get_Posts() {
        val observable = API.apiService.getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        val observer = object : Observer<List<Post>>{

            override fun onSubscribe(d: Disposable) {
            }


            override fun onNext(t: List<Post>) {
                _Posts.postValue(t)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError: ${e.message}")
            }


            override fun onComplete() {
            }
        }

        observable.subscribe(observer)
    }
}