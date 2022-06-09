package com.example.composeunsplash.di

import com.example.composeunsplash.*
import com.example.composeunsplash.data.local.FavoriteRepository
import com.example.composeunsplash.remote.PhotoRepository

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(),get()) }
    viewModel { DetailViewModelSearch(get(),get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel{ SearchViewModel(get())}
}

val repositoryModule= module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}