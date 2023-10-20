package com.example.foodorderingapp.presentation.sepet

import com.example.foodorderingapp.domain.model.SepettekiYemekDto

data class SepettenYemekSilState(
    var isEmittedOnce: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: SepettekiYemekDto? = null)