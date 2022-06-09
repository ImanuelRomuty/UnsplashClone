package com.example.composeunsplash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeunsplash.remote.PhotoRemoteDataSource
import com.example.composeunsplash.remote.PhotoRepository
import com.example.composeunsplash.data.api.Result
class SearchViewModel(private val repository: PhotoRepository):ViewModel() {
    //Live Data
    private val photoSplashSearch : MutableLiveData<List<Result>> by lazy {
        MutableLiveData<List<Result>>()
    }
    fun photoSearch(): LiveData<List<Result>> {
        Log.d("cekSearcha",photoSplashSearch.value.toString())
        return photoSplashSearch
    }
    fun getPhotoSearch(query: String){
        repository.searchPhoto(object : PhotoRemoteDataSource.SearchCallBack{
            override fun onComplete(listResult: List<Result>) {
                photoSplashSearch.value = listResult
            }
            override fun onError() {
                Log.d("error","error")
            }
        }, query = query)
    }
}