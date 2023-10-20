package com.example.foodorderingapp

import android.app.Application
import android.content.Context
import com.example.foodorderingapp.di.AppModule
import com.example.foodorderingapp.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApp: Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(listOf(NetworkModule, AppModule))
        }
    }

    companion object {
        private var instance: BaseApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}