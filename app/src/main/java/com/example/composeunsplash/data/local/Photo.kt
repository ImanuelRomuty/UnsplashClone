package com.example.composeunsplash.data.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Photo(
    @PrimaryKey(autoGenerate = true)    var id : Int? = null,
    @ColumnInfo(name=  "imagepath")     var imagePath: String? = null,
    @ColumnInfo(name= "description")    var description : String? = null
): Parcelable