package com.example.composeunsplash.network


import com.example.composeunsplash.data.api.PhotoResponse
import com.example.composeunsplash.data.api.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //home
    @GET("search/photos?query=london&client_id=M7EaUVLsM_2BuWsVMhDcAL9R2duqDsWGkDQweVr9_lc")
    suspend fun allPhoto():Response<PhotoResponse>

    //id
    @GET("photos/{id}?client_id=M7EaUVLsM_2BuWsVMhDcAL9R2duqDsWGkDQweVr9_lc&=")
    suspend fun searchPhotoWithId(
        @Path("id")id:String
    ):Response<Result>

    @GET("search/photos/?client_id=M7EaUVLsM_2BuWsVMhDcAL9R2duqDsWGkDQweVr9_lc")
    suspend fun searchPhoto(
        @Query("query") query: String
    ):Response<PhotoResponse>
}