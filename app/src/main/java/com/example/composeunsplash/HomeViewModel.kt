package com.example.composeunsplash

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
//    private val photo :
/*    var image : List<Result> by mutableStateOf<List<Result>>(listOf()).also {
        getPhoto()
    Log.d("cekViewModel",getPhoto().toString())
}*/

    //Live Data
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
                Log.d("CEKK",photoSplash.value.toString())
            }
            override fun onError() {
                Log.d("Error", "Error")
            }
        })
    }
}