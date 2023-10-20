package com.example.foodorderingapp.presentation.anasayfa

import com.example.foodorderingapp.domain.model.SepeteYemekEkleDto

data class SepeteYemekEkleState(
    var isEmittedOnce: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: SepeteYemekEkleDto? = null
)
