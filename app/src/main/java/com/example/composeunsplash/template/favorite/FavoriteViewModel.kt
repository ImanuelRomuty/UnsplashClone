package com.example.composeunsplash.template.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeunsplash.data.local.FavoriteRepository
import com.example.composeunsplash.data.local.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FavoriteViewModel(private val repository: FavoriteRepository): ViewModel() {
    private val photoSplash : MutableLiveData<List<Photo>> by lazy {
        MutableLiveData<List<Photo>>().also {
            favoritePhoto()
        }
    }

    fun photo(): LiveData<List<Photo>> {
        return photoSplash
    }

    private fun favoritePhoto(){
        viewModelScope.launch(Dispatchers.IO){
            val result = repository.getFavorite()
            runBlocking(Dispatchers.Main){
                photoSplash.value = result
            }
        }

    }
}