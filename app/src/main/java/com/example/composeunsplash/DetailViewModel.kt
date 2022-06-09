package com.example.composeunsplash


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeunsplash.data.local.FavoriteRepository
import com.example.composeunsplash.remote.PhotoRemoteDataSource
import com.example.composeunsplash.remote.PhotoRepository
import com.example.composeunsplash.data.api.Result
import com.example.composeunsplash.data.local.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class DetailViewModel(
    private val repository: PhotoRepository,
    private val favoriteRepository: FavoriteRepository

) : ViewModel() {
    private val detailPhoto: MutableLiveData<Result> by lazy {
        MutableLiveData<Result>()
    }
    fun searchPhoto(id:String){
        repository.detailPhoto(object : PhotoRemoteDataSource.DetailCallBack{
            override fun onComplete(listResult: Result) {
                Log.d("detailPoto",listResult.toString())
                detailPhoto.value = listResult
            }
            override fun onError() {
                Log.d("terpaksa","paksa")
            }
        },id)
    }


    fun detailPhoto(): LiveData<Result> {
        return detailPhoto
    }


    fun insertPhoto(photo: Photo){
        viewModelScope.launch(Dispatchers.IO){
            val result = favoriteRepository.insertPhoto(photo)
            runBlocking(Dispatchers.Main){
                if (result !=0. toLong()){
                    Log.d("sukses","sukses")
                }
            }
        }
    }
}