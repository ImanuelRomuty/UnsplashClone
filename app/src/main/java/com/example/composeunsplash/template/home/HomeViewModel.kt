package com.example.composeunsplash.template.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeunsplash.data.api.Result
import com.example.composeunsplash.remote.PhotoRemoteDataSource
import com.example.composeunsplash.remote.PhotoRepository

class HomeViewModel(
    private val repository: PhotoRepository
) :ViewModel(){

    val photoSplash : MutableLiveData<List<Result>> by lazy {
        MutableLiveData<List<Result>>().also {
            getPhoto()
        }
    }
    fun photo(): LiveData<List<Result>> {
        return photoSplash
    }
    private fun getPhoto(){
        repository.getPhoto(object : PhotoRemoteDataSource.MovieCallback{
            override fun onComplete(listResult: List<Result>) {
                photoSplash.value = listResult
            }
            override fun onError() {
                Log.d("Error", "Error")
            }
        })
    }
}