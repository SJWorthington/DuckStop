package com.sworthington.baseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sworthington.baseapplication.di.ComponentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private inline fun <reified T : ViewModel> getViewModel(): T = ViewModelProvider(this, viewModelFactory).get(T::class.java)

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ComponentInjector.getInjector().inject(this)

        viewModel = getViewModel()
    }
}
