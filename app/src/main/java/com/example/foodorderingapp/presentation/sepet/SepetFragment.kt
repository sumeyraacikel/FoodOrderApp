package com.example.foodorderingapp.presentation.sepet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.databinding.FragmentSepetBinding
import com.example.foodorderingapp.domain.model.SepettekiYemekDto
import org.koin.androidx.viewmodel.ext.android.viewModel

class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private val viewModel: SepetViewModel by viewModel()

    private var currentProductAmount = 0
    private var currentPrice = 0

    private lateinit var sepetYemeklerAdapter: SepetYemeklerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSepetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeSepettekiYemekleriGetir()
        observeSepettenYemekSil()
        sepettekiYemekleriGetir("sumeyra_acikel")

    }

    private fun initAdapter() {
        binding.rvSepetYemekler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            sepetYemeklerAdapter = SepetYemeklerAdapter { silinecekId ->
                yemekSil(silinecekId, "sumeyra_acikel")
            }
            adapter = sepetYemeklerAdapter
        }
    }

    private fun yemekSil(silinecekId: Int, kullanici_adi: String) {
        viewModel.sepettenYemekSil(silinecekId, kullanici_adi)
    }

    private fun sepettekiYemekleriGetir(kullanici_adi: String) {
        viewModel.sepettekiYemekleriGetir(kullanici_adi)
    }

    private fun observeSepettekiYemekleriGetir() {
        viewModel.sepettekiYemekleriGetir.observe(viewLifecycleOwner, Observer {
            if(it.isEmittedOnce) {
                return@Observer
            }
            if (it.isLoading) {
                //Loading
            } else {
                if (it.error != null) {
                    sepetYemeklerAdapter.updateList(ArrayList())
                } else {
                    updateUIPriceBar(it.data!!.sepettekiYemekler)
                    sepetYemeklerAdapter.updateList(it.data!!.sepettekiYemekler)
                }
            }
            viewModel.sepettekiYemekleriGetir.value!!.isEmittedOnce = true
        })

    }

    private fun updateUIPriceBar(yemekler: ArrayList<SepettekiYemekDto>) {
        var totalPrice = 0
        for(yemek in yemekler) {
            totalPrice += (yemek.yemek_siparis_adet.toInt() * yemek.yemek_fiyat.toInt())
        }
        binding.tvFiyat.text = "${totalPrice}₺"
        binding.tvUrunSayisi.text = "${yemekler.size} Ürün"

        currentPrice = totalPrice
        currentProductAmount = yemekler.size
    }

    private fun observeSepettenYemekSil() {
        viewModel.sepettenYemekSil.observe(viewLifecycleOwner, Observer {
            if(it.isEmittedOnce) {
                return@Observer
            }
            if (it.isLoading) {
                //Loading
            } else {
                if (it.error != null) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "İşlem Başarılı", Toast.LENGTH_SHORT).show()
                    sepettekiYemekleriGetir("sumeyra_acikel")
                }
            }
            viewModel.sepettenYemekSil.value!!.isEmittedOnce = true
        })
    }
}