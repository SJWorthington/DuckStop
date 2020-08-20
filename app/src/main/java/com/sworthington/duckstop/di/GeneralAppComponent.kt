package com.sworthington.duckstop.di

import android.app.Application
import com.sworthington.duckstop.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GeneralDependencyProvider::class])
internal interface GeneralAppComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): GeneralAppComponent
    }
}