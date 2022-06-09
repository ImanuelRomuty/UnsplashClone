package com.example.composeunsplash.data.local


import com.example.composeunsplash.data.api.Result

class FavoriteRepository constructor(private val  photoDao: PhotoDao) {
    suspend fun insertPhoto(photo: Photo):Long{
        return photoDao.addPhoto(photo)
    }

    suspend fun getFavorite(): List<Photo> {
        return photoDao.getPhoto()
    }

}