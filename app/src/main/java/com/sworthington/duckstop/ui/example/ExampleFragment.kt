package com.sworthington.duckstop.ui.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sworthington.duckstop.R
import com.sworthington.duckstop.base.BaseFragment

internal class ExampleFragment : BaseFragment() {

    private val viewModel by lazy { getViewModel() as ExampleViewModel }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }
}