package com.example.foodorderingapp.di

import com.example.foodorderingapp.data.retrofit.YemeklerDao
import com.example.foodorderingapp.data.repository.AnasayfaRepositoryImpl
import com.example.foodorderingapp.data.repository.SepetRepositoryImpl
import com.example.foodorderingapp.domain.repository.AnasayfaRepository
import com.example.foodorderingapp.domain.repository.SepetRepository
import com.example.foodorderingapp.presentation.anasayfa.AnasayfaViewModel
import com.example.foodorderingapp.presentation.detay.DetayViewModel
import com.example.foodorderingapp.presentation.sepet.SepetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { AnasayfaViewModel(get()) }
    viewModel { SepetViewModel(get()) }
    viewModel { DetayViewModel(get()) }

    single { provideAnasayfaRepository(get()) }

    single { provideSepetRepository(get()) }
}

fun provideAnasayfaRepository(apiService: YemeklerDao): AnasayfaRepository =
    AnasayfaRepositoryImpl(apiService)

fun provideSepetRepository(apiService: YemeklerDao) : SepetRepository =
    SepetRepositoryImpl(apiService)

