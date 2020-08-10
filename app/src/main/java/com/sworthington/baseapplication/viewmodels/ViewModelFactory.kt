package com.sworthington.baseapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
internal class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(type: Class<T>): T {
        val viewModel = viewModels[type]?.get()

        checkNotNull(viewModel) { "View Model ($type) NULL!" }

        check(type.isInstance(viewModel)) { "View Model not instance of $type!" }

        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        return type.cast(viewModel)
    }
}