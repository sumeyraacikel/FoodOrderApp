package com.example.foodorderingapp.presentation.detay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodorderingapp.domain.model.Resource
import com.example.foodorderingapp.domain.repository.AnasayfaRepository
import com.example.foodorderingapp.presentation.anasayfa.SepeteYemekEkleState
import kotlinx.coroutines.launch

class DetayViewModel constructor(private val anasayfaRepository: AnasayfaRepository): ViewModel(){
    val sepeteYemekEkle = MutableLiveData<SepeteYemekEkleState>()

    fun sepeteYemekEkle(yemek_adi: String, yemek_resim_adi: String, yemek_fiyati: Int, adet: Int, kullanici_adi: String ){
        viewModelScope.launch {
            sepeteYemekEkle.postValue(SepeteYemekEkleState(isLoading = true))
            anasayfaRepository.sepeteYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyati, adet, kullanici_adi).apply {
                when (this) {
                    is Resource.Success -> {
                        sepeteYemekEkle.postValue(
                            SepeteYemekEkleState(
                                isLoading = false,
                                error = null,
                                data = this.data
                            )
                        )
                    }
                    else -> {
                        sepeteYemekEkle.postValue(
                            SepeteYemekEkleState(
                                isLoading = false,
                                error = this.message,
                                data = null
                            )
                        )
                    }
                }
            }
        }
    }
}