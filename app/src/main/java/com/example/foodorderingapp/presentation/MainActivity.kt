package com.example.foodorderingapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostView) as NavHostFragment
        NavigationUI.setupWithNavController(tasarim.bottomNavView,navHostFragment.navController)
    }
}