package com.example.composeunsplash.remote

import com.example.composeunsplash.data.api.Result
import com.example.composeunsplash.network.ApiService
import kotlinx.coroutines.*


class PhotoRemoteDataSource(private val apiService: ApiService) {
    interface MovieCallback {
        fun onComplete(listResult: List<Result>)
        fun onError()
    }
    interface DetailCallBack{
        fun onComplete(listResult: Result)
        fun onError()
    }
    interface SearchCallBack{
        fun onComplete(listResult: List<Result>)
        fun onError()
    }


    @OptIn(DelicateCoroutinesApi::class)
    fun getPhoto(movieCallback: MovieCallback):List<Result>{
        GlobalScope.launch(Dispatchers.IO){
            val response = apiService.allPhoto()
            runBlocking(Dispatchers.Main){
                if (response.isSuccessful){
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            movieCallback.onComplete(it.results)
                        }
                    }
                }else{
                    movieCallback.onError()
                }
            }
        }
        return emptyList()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getDetailPhoto(detailCallback: DetailCallBack,id:String): Result {
        GlobalScope.launch(Dispatchers.IO){
            val response = apiService.searchPhotoWithId(id)
            runBlocking(Dispatchers.Main){
                if (response.isSuccessful){
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            if (result != null) {
                                detailCallback.onComplete(it)
                            }
                        }
                    }
                }else{
                    detailCallback.onError()
                }
            }
        }
        return Result(id = id)
    }


    fun searchPhoto(searchCallBack: SearchCallBack,query: String):List<Result>{
        GlobalScope.launch(Dispatchers.IO){
            val response = apiService.searchPhoto(query)
            runBlocking(Dispatchers.Main){
                if (response.isSuccessful){
                    val result = response.body()
                    result.let {
                        if (it != null) {
                            searchCallBack.onComplete(it.results)
                        }
                    }
                }
            }
        }
        return emptyList()
    }
}