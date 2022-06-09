package com.example.composeunsplash.data.api


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns
)