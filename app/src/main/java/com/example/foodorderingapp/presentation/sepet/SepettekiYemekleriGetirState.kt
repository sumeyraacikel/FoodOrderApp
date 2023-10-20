package com.example.foodorderingapp.presentation.sepet


import com.example.foodorderingapp.domain.model.SepettekiYemekleriGetirDto

data class SepettekiYemekleriGetirState(
    var isEmittedOnce: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: SepettekiYemekleriGetirDto? = null
)
