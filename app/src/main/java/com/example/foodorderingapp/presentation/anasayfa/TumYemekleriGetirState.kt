package com.example.foodorderingapp.presentation.anasayfa

import com.example.foodorderingapp.domain.model.TumYemekleriGetirDto

data class TumYemekleriGetirState(
    var isEmittedOnce: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: TumYemekleriGetirDto? = null
)
