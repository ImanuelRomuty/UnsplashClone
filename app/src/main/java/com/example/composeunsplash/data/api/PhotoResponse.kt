package com.example.composeunsplash.data.api


import com.example.composeunsplash.data.api.Result
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)