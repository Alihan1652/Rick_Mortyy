package com.example.rick_mortyy.presentation

import android.app.Application
import com.example.rick_mortyy.data.di.dataModule
import com.example.rick_mortyy.data.di.domainModule
import com.example.rick_mortyy.data.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CartoonApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CartoonApp)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}