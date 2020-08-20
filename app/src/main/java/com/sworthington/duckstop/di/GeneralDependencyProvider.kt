package com.sworthington.duckstop.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sworthington.duckstop.MainActivityViewModel
import com.sworthington.duckstop.network.RetrofitProvider
import com.sworthington.duckstop.ui.example.ExampleViewModel
import com.sworthington.duckstop.viewmodels.ViewModelFactory
import com.sworthington.duckstop.viewmodels.ViewModelMapKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [APIDependencyProvider::class, GeneralDependencyBinder::class])
object GeneralDependencyProvider {

    @JvmStatic
    @Provides
    @Singleton
    fun provideGSON(): Gson = GsonBuilder()
        .disableHtmlEscaping()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit = RetrofitProvider(gson).getRetrofit()

    //TODO - remove above provides functions if not using gson or Retrofit
}

@Module
internal interface GeneralDependencyBinder {

    @Binds
    fun bindContext(application: Application): Context

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelMapKey(MainActivityViewModel::class)
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelMapKey(ExampleViewModel::class)
    fun bindExampleViewModel(viewModel: ExampleViewModel): ViewModel

   //TODO - bind Fragment ViewModels here
}
