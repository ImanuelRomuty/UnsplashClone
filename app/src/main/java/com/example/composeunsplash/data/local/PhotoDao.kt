package com.example.composeunsplash.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PhotoDao {
    @Query("SELECT * FROM Photo")
    fun getPhoto(): List<Photo>

    @Insert
    fun addPhoto(photo: Photo): Long

    @Update
    fun updatePhoto(photo: Photo) : Int
}