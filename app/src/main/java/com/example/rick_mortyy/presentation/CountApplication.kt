package com.example.rick_mortyy.presentation

import android.app.Application
import com.example.rick_mortyy.data.di.cartoonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CountApplication: Application() {
        override fun onCreate() {
            super.onCreate()

            startKoin {
                androidLogger(Level.DEBUG)
                androidContext(this@CountApplication)
                modules(modules = cartoonModule)
            }
        }
    }