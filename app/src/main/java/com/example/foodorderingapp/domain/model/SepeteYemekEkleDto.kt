package com.example.foodorderingapp.domain.model

import com.google.gson.annotations.SerializedName

data class SepeteYemekEkleDto(
    @SerializedName("success")
    var success: Int,
    @SerializedName("message")
    var message: String
)
