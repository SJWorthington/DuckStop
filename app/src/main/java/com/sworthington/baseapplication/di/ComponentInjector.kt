package com.sworthington.baseapplication.di

import android.app.Application

internal object ComponentInjector {

    private var generalAppComponent: GeneralAppComponent? = null

    fun init(app: Application) {
        if (generalAppComponent != null) return

        generalAppComponent = DaggerGeneralAppComponent.builder().application(app).build()
    }

    fun getInjector() : GeneralAppComponent = requireNotNull(generalAppComponent) {"App component not initialised"}
}