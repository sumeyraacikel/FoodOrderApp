package com.example.foodorderingapp.domain.model

import com.google.gson.annotations.SerializedName

data class SepettekiYemekleriGetirDto(
    @SerializedName("sepet_yemekler")
    val sepettekiYemekler: ArrayList<SepettekiYemekDto>,
    @SerializedName("success")
    val success: Int
)