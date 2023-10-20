package com.example.foodorderingapp.domain.repository

import com.example.foodorderingapp.domain.model.Resource
import com.example.foodorderingapp.domain.model.SepeteYemekEkleDto
import com.example.foodorderingapp.domain.model.TumYemekleriGetirDto

interface AnasayfaRepository {

    suspend fun tumYemekleriGetir(): Resource<TumYemekleriGetirDto>

    suspend fun sepeteYemekEkle(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ): Resource<SepeteYemekEkleDto>
}