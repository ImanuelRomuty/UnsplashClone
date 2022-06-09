package com.example.composeunsplash.remote


import com.example.composeunsplash.data.api.Result

class PhotoRepository constructor(
    private val photoRemoteDataSource: PhotoRemoteDataSource
    ) {
    fun getPhoto(movieCallback: PhotoRemoteDataSource.MovieCallback): List<Result> {
        return photoRemoteDataSource.getPhoto(movieCallback)
    }
    fun detailPhoto(movieCallback: PhotoRemoteDataSource.DetailCallBack,id:String): Result {
        return photoRemoteDataSource.getDetailPhoto(movieCallback,id)
    }
    fun searchPhoto(searchCallBack: PhotoRemoteDataSource.SearchCallBack,query:String):List<Result>{
        return photoRemoteDataSource.searchPhoto(searchCallBack,query)
    }

}