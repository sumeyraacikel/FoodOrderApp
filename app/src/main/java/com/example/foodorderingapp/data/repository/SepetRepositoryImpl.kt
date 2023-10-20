package com.example.foodorderingapp.data.repository

import com.example.foodorderingapp.data.retrofit.YemeklerDao
import com.example.foodorderingapp.domain.exception.traceErrorException
import com.example.foodorderingapp.domain.model.Resource
import com.example.foodorderingapp.domain.model.SepettekiYemekDto
import com.example.foodorderingapp.domain.model.SepettekiYemekleriGetirDto
import com.example.foodorderingapp.domain.repository.SepetRepository
import kotlinx.coroutines.CancellationException
import java.lang.Exception

class SepetRepositoryImpl(private val api:YemeklerDao) : SepetRepository {
    override suspend fun sepettekiYemekleriGetir(kullanici_adi: String): Resource<SepettekiYemekleriGetirDto> {
        return try {
            Resource.Success(api.sepettekiYemekleriGetir(kullanici_adi))
        } catch (e: CancellationException) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        }
    }

    override suspend fun sepettenYemekSil(sepet_yemek_id: Int, kullanici_adi: String): Resource<SepettekiYemekDto> {
        return try {
            Resource.Success(api.sepettenYemekSil(sepet_yemek_id,kullanici_adi))
        } catch (e: CancellationException) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(traceErrorException(e).getErrorMessage())
        }
    }

}

