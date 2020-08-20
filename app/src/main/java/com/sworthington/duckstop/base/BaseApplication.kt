package com.sworthington.duckstop.base

import android.app.Application
import com.sworthington.duckstop.di.ComponentInjector

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentInjector.init(this)
    }
}