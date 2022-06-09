package com.example.composeunsplash.data.api


import com.google.gson.annotations.SerializedName

data class TopicSubmissionsX(
    @SerializedName("nature")
    val nature: Nature,
    @SerializedName("travel")
    val travel: Travel
)