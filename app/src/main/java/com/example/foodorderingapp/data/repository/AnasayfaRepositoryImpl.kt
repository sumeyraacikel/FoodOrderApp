package com.example.foodorderingapp.data.repository

import com.example.foodorderingapp.data.retrofit.YemeklerDao
import com.example.foodorderingapp.domain.exception.traceErrorException
import com.example.foodorderingapp.domain.model.Resource
import com.example.foodorderingapp.domain.model.SepeteYemekEkleDto
import com.example.foodorderingapp.domain.model.TumYemekleriGetirDto
import com.example.foodorderingapp.domain.repository.AnasayfaRepository
import kotlinx.coroutines.CancellationException
import java.lang.Exception

class AnasayfaRepositoryImpl(private val api: YemeklerDao) : AnasayfaRepository {

    override suspend fun tumYemekleriGetir(): Resource<TumYemekleriGetirDto> {
        return try {
            Resource.Success(api.tumYemekleriGetir())
        } catch (e: CancellationException) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        }
    }

    override suspend fun sepeteYemekEkle(
        yemek_adi: String,
        yemek_resim_adi: String,
        yemek_fiyat: Int,
        yemek_siparis_adet: Int,
        kullanici_adi: String
    ): Resource<SepeteYemekEkleDto> {
        return try {
            Resource.Success(
                api.sepeteYemekEkle(
                    yemek_adi,
                    yemek_resim_adi,
                    yemek_fiyat,
                    yemek_siparis_adet,
                    kullanici_adi
                )
            )
        } catch (e: CancellationException) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        }
    }
}