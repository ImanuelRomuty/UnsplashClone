package com.example.composeunsplash.di


import com.example.composeunsplash.data.local.FavoriteRepository
import com.example.composeunsplash.remote.PhotoRepository
import com.example.composeunsplash.template.detail.DetailViewModel
import com.example.composeunsplash.template.favorite.FavoriteViewModel
import com.example.composeunsplash.template.home.HomeViewModel
import com.example.composeunsplash.template.search.SearchViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(),get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel{ SearchViewModel(get()) }
}

val repositoryModule= module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}