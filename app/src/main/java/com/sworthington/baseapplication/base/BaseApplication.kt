package com.sworthington.baseapplication.base

import android.app.Application
import com.sworthington.baseapplication.di.ComponentInjector

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentInjector.init(this)
    }
}