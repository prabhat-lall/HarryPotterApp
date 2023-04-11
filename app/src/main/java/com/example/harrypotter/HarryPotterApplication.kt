package com.example.harrypotter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HarryPotterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}