package com.example.composeunsplash.di

import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.composeunsplash.data.local.ApplicationDatabase
import com.example.composeunsplash.network.ApiService
import com.example.composeunsplash.remote.PhotoRemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val localModule = module {
    factory { get<ApplicationDatabase>().photoDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ApplicationDatabase::class.java, "Photo18dd56665s2423.db").fallbackToDestructiveMigration().build()
    }
}


val networkModule= module {
    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(androidContext()))
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }

}
val remoteDataSourceModule = module {
    single { PhotoRemoteDataSource(get()) }
}