package com.example.composeunsplash.data.api


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Result(
    @SerializedName("alt_description")
    val altDescription: String?=null,
    @SerializedName("blur_hash")
    val blurHash: String?=null,
    @SerializedName("created_at")
    val createdAt: String?=null,
    @SerializedName("description")
    val description: String?=null,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Int?=null,
    @SerializedName("updated_at")
    val updatedAt: String?=null,
    @SerializedName("urls")
    val urls: UrlsX?=null,
    @SerializedName("width")
    val width: Int?=null
):Parcelable