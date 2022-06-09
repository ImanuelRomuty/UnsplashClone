package com.example.composeunsplash.data.local



class FavoriteRepository constructor(private val  photoDao: PhotoDao) {
    fun insertPhoto(photo: Photo):Long{
        return photoDao.addPhoto(photo)
    }

    fun getFavorite(): List<Photo> {
        return photoDao.getPhoto()
    }

}