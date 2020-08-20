package com.sworthington.duckstop.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

internal abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal inline fun <reified T : ViewModel> getViewModel(): T {
        return ViewModelProvider(this, viewModelFactory).get(T::class.java)
    }
}