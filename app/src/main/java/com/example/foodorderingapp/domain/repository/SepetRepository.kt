package com.example.foodorderingapp.domain.repository

import com.example.foodorderingapp.domain.model.Resource
import com.example.foodorderingapp.domain.model.SepettekiYemekDto
import com.example.foodorderingapp.domain.model.SepettekiYemekleriGetirDto

interface SepetRepository {

    suspend fun sepettekiYemekleriGetir(kullanici_adi: String):Resource<SepettekiYemekleriGetirDto>

    suspend fun sepettenYemekSil(sepet_yemek_id:Int,kullanici_adi:String): Resource<SepettekiYemekDto>


}