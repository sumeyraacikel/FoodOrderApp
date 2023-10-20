package com.example.foodorderingapp.presentation.anasayfa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodorderingapp.databinding.FragmentAnasayfaBinding
import com.example.foodorderingapp.domain.model.YemekDto
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private val viewModel: AnasayfaViewModel by viewModel()

    private lateinit var yemeklerAdapter: AnasayfaYemeklerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeTumYemekler()
        observeSepeteYemekEkle()
        getYemekler()
    }

    private fun initAdapter() {
        binding.rvYemekler.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            yemeklerAdapter = AnasayfaYemeklerAdapter { secilenYemek, adet, ACTION_TYPE ->
                if(ACTION_TYPE == ACTION_SEPETE_EKLE) {
                    sepeteEkle(secilenYemek, adet)
                }
                if(ACTION_TYPE == ACTION_DETAYA_GIT) {
                    val action = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(secilenYemek)
                    findNavController().navigate(action)
                }

            }
            adapter = yemeklerAdapter
        }
    }

    private fun sepeteEkle(yemek: YemekDto, adet: Int) {
        viewModel.sepeteYemekEkle(
            yemek.yemek_adi,
            yemek.yemek_resim_adi,
            yemek.yemek_fiyat.toInt(),
            adet,
            "sumeyra_acikel"
        )
    }

    private fun getYemekler() {
        viewModel.tumYemekleriGetir()
    }

    private fun observeTumYemekler() {
        viewModel.tumYemekleriGetir.observe(viewLifecycleOwner, Observer {
            if (it.isEmittedOnce) {
                return@Observer
            }
            if (it.isLoading) {
                //Loading
            } else {
                if (it.error != null) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                } else {
                    yemeklerAdapter.updateList(it.data!!.yemekler)
                }
            }
            viewModel.tumYemekleriGetir.value!!.isEmittedOnce = true
        })
    }

    private fun observeSepeteYemekEkle() {
        viewModel.sepeteYemekEkle.observe(viewLifecycleOwner, Observer {
            if (it.isEmittedOnce) {
                return@Observer
            }
            if (it.isLoading) {
                //Loading
            } else {
                if (it.error != null) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "İşlem Başarılı", Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.sepeteYemekEkle.value!!.isEmittedOnce = true
        })
    }
}